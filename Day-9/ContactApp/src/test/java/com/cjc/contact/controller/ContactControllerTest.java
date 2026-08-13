package com.cjc.contact.controller;

import com.cjc.contact.dto.ContactDTO;
import com.cjc.contact.exception.ContactNotFoundException;
import com.cjc.contact.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cjc.contact.exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

@WebMvcTest(ContactController.class)
@Import(GlobalExceptionHandler.class)
class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @Autowired
    private ObjectMapper objectMapper;

    private ContactDTO contactDTO;

    @BeforeEach
    void setUp() {
        contactDTO = new ContactDTO(1L, "Rahul Sharma", "rahul@example.com", "9876543210", "Work");
    }

    @Test
    void testCreateContact_Success() throws Exception {
        when(contactService.createContact(any(ContactDTO.class))).thenReturn(contactDTO);

        mockMvc.perform(post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contactDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Contact created successfully"))
                .andExpect(jsonPath("$.data.name").value("Rahul Sharma"));

        verify(contactService, times(1)).createContact(any(ContactDTO.class));
    }

    @Test
    void testGetAllContacts_Success() throws Exception {
        ContactDTO contact2 = new ContactDTO(2L, "Priya Verma", "priya@example.com", "9123456789", "Personal");
        when(contactService.getAllContacts()).thenReturn(Arrays.asList(contactDTO, contact2));

        mockMvc.perform(get("/api/contacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.length()").value(2))
                .andExpect(jsonPath("$.data[0].name").value("Rahul Sharma"));

        verify(contactService, times(1)).getAllContacts();
    }

    @Test
    void testGetContactById_Success() throws Exception {
        when(contactService.getContactById(1L)).thenReturn(contactDTO);

        mockMvc.perform(get("/api/contacts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.email").value("rahul@example.com"));

        verify(contactService, times(1)).getContactById(1L);
    }

    @Test
    void testGetContactById_NotFound() throws Exception {
        when(contactService.getContactById(99L)).thenThrow(new ContactNotFoundException("Contact not found with ID: 99"));

        mockMvc.perform(get("/api/contacts/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.message").value("Contact not found with ID: 99"));

        verify(contactService, times(1)).getContactById(99L);
    }

    @Test
    void testDeleteContact_Success() throws Exception {
        doNothing().when(contactService).deleteContact(1L);

        mockMvc.perform(delete("/api/contacts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Contact deleted successfully with ID: 1"));

        verify(contactService, times(1)).deleteContact(1L);
    }
}
