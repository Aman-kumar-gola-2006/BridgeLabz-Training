package com.cjc.payroll.controller;

import com.cjc.payroll.dto.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateEmployeeSuccess() throws Exception {
        EmployeeDTO dto = new EmployeeDTO(null, "John Doe", "john.doe@company.com", "IT", 75000.0, LocalDate.of(2023, 1, 15));

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.empId").exists())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@company.com"))
                .andExpect(jsonPath("$.dept").value("IT"))
                .andExpect(jsonPath("$.salary").value(75000.0));
    }

    @Test
    public void testCreateEmployeeWithGmailRejected() throws Exception {
        EmployeeDTO dto = new EmployeeDTO(null, "Jane Doe", "jane.doe@gmail.com", "HR", 65000.0, LocalDate.of(2022, 5, 10));

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400));
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testFullCrudLifecycle() throws Exception {
        EmployeeDTO createDto = new EmployeeDTO(null, "Alice Smith", "alice.smith@techcorp.com", "Finance", 80000.0, LocalDate.of(2021, 3, 20));

        String response = mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        EmployeeDTO created = objectMapper.readValue(response, EmployeeDTO.class);
        Long id = created.getEmpId();

        mockMvc.perform(get("/api/employees/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice Smith"));

        created.setSalary(85000.0);
        mockMvc.perform(put("/api/employees/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(created)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").value(85000.0));

        mockMvc.perform(delete("/api/employees/" + id))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/employees/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testSearchEmployeesPaginationAndQBE() throws Exception {
        EmployeeDTO e1 = new EmployeeDTO(null, "Charlie Pagination", "charlie@company.com", "Engineering", 120000.0, LocalDate.of(2020, 1, 1));
        EmployeeDTO e2 = new EmployeeDTO(null, "Alice Sorting", "alice.sorting@company.com", "Engineering", 90000.0, LocalDate.of(2021, 2, 2));

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(e1))).andExpect(status().isCreated());
        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(e2))).andExpect(status().isCreated());

        // Test Pagination, Sorting (name asc) and Filtering (dept=Engineering)
        mockMvc.perform(get("/api/employees/search")
                .param("pageNo", "0")
                .param("pageSize", "10")
                .param("sortBy", "name")
                .param("sortDir", "asc")
                .param("dept", "Engineering"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].name").value("Alice Sorting"))
                .andExpect(jsonPath("$.totalElements").isNumber());
    }
}
