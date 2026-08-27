package com.cjc.payroll.controller;

import com.cjc.payroll.dto.DepartmentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateDepartmentSuccess() throws Exception {
        DepartmentDTO dto = new DepartmentDTO(null, "Information Technology", "IT-101", "Building A");

        mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.deptId").exists())
                .andExpect(jsonPath("$.deptName").value("Information Technology"))
                .andExpect(jsonPath("$.deptCode").value("IT-101"))
                .andExpect(jsonPath("$.location").value("Building A"));
    }

    @Test
    public void testFullDepartmentCrudLifecycle() throws Exception {
        DepartmentDTO createDto = new DepartmentDTO(null, "Human Resources", "HR-202", "Building B");

        String response = mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        DepartmentDTO created = objectMapper.readValue(response, DepartmentDTO.class);
        Long id = created.getDeptId();

        mockMvc.perform(get("/api/departments/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deptName").value("Human Resources"));

        created.setLocation("Building C");
        mockMvc.perform(put("/api/departments/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(created)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("Building C"));

        mockMvc.perform(delete("/api/departments/" + id))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/departments/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testSearchDepartmentsPaginationAndQBE() throws Exception {
        DepartmentDTO d1 = new DepartmentDTO(null, "Sales", "SLS-101", "Building C");
        DepartmentDTO d2 = new DepartmentDTO(null, "Marketing", "MKT-102", "Building C");

        mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(d1))).andExpect(status().isCreated());
        mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(d2))).andExpect(status().isCreated());

        // Test Pagination, Sorting (deptName desc) and Filtering (location=Building C)
        mockMvc.perform(get("/api/departments/search")
                .param("pageNo", "0")
                .param("pageSize", "10")
                .param("sortBy", "deptName")
                .param("sortDir", "desc")
                .param("location", "Building C"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].deptName").value("Sales")) // Descending, so Sales before Marketing
                .andExpect(jsonPath("$.totalElements").isNumber());
    }
}
