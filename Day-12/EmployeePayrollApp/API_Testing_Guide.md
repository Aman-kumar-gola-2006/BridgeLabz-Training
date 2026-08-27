# Pagination & Search Testing Guide

To test the pagination and dynamic search (Query by Example) features manually, you need to run your Spring Boot application first, and then you can use tools like **Postman**, **cURL**, or simply your **Web Browser**.

Here is a step-by-step guide on how to test it:

### Step 1: Start Your Application
Run your Spring Boot application (either from Eclipse/IntelliJ or by running `mvn spring-boot:run` in the terminal). Make sure it starts successfully on port `8080` (or whatever your configured port is).

### Step 2: Add Some Dummy Data
Since you are using an in-memory H2 database, it will be empty when you restart the app. You need to create a few records first using a `POST` request.

**Add a few Departments:**
- Send `POST` to `http://localhost:8080/api/departments`
  ```json
  { "deptName": "IT", "deptCode": "IT-101", "location": "Building A" }
  ```
- Send `POST` to `http://localhost:8080/api/departments`
  ```json
  { "deptName": "HR", "deptCode": "HR-202", "location": "Building B" }
  ```
- Send `POST` to `http://localhost:8080/api/departments`
  ```json
  { "deptName": "Finance", "deptCode": "FIN-303", "location": "Building A" }
  ```

---

### Step 3: Test the Pagination & Search API

Now you can test the `GET /search` endpoints using URL Query Parameters.

#### Scenario 1: Basic Pagination (Get the first page of size 2)
**GET URL:**
`http://localhost:8080/api/departments/search?pageNo=0&pageSize=2`

**Expected Response:**
You will get a JSON response showing exactly 2 records, and metadata saying there are more pages available.
```json
{
    "content": [
        { "deptId": 1, "deptName": "IT", "deptCode": "IT-101", "location": "Building A" },
        { "deptId": 2, "deptName": "HR", "deptCode": "HR-202", "location": "Building B" }
    ],
    "pageNo": 0,
    "pageSize": 2,
    "totalElements": 3,
    "totalPages": 2,
    "last": false
}
```
*(To get the next page, just change `pageNo=1` in the URL).*

#### Scenario 2: Sorting Data (Descending by Department Name)
**GET URL:**
`http://localhost:8080/api/departments/search?sortBy=deptName&sortDir=desc`

**Expected Response:**
It will sort alphabetically from Z to A. So `IT`, then `HR`, then `Finance`.

#### Scenario 3: Dynamic Search / Filtering (Query By Example)
Let's say you only want to find Departments that are located in "Building A".

**GET URL:**
`http://localhost:8080/api/departments/search?location=Building A`

**Expected Response:**
Only IT and Finance will be returned, as HR is in Building B.

#### Scenario 4: Combining Pagination, Sorting, and Searching
You can mix all of them together. For example, find all employees in the "IT" department, sort their salary descending, and show me page 1 with 5 items per page:

**GET URL (for employees):**
`http://localhost:8080/api/employees/search?dept=IT&sortBy=salary&sortDir=desc&pageNo=0&pageSize=5`
