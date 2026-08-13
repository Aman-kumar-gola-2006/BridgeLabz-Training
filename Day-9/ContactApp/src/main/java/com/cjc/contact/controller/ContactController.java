package com.cjc.contact.controller;

import com.cjc.contact.dto.ApiResponse;
import com.cjc.contact.dto.ContactDTO;
import com.cjc.contact.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

 
    @PostMapping
    public ResponseEntity<ApiResponse<ContactDTO>> createContact(@Valid @RequestBody ContactDTO contactDTO) {
        ContactDTO createdContact = contactService.createContact(contactDTO);
        ApiResponse<ContactDTO> response = new ApiResponse<>(
                true,
                "Contact created successfully",
                createdContact
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

 
    @GetMapping
    public ResponseEntity<ApiResponse<List<ContactDTO>>> getAllContacts() {
        List<ContactDTO> contacts = contactService.getAllContacts();
        ApiResponse<List<ContactDTO>> response = new ApiResponse<>(
                true,
                "Fetched all contacts successfully",
                contacts
        );
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ContactDTO>> getContactById(@PathVariable Long id) {
        ContactDTO contact = contactService.getContactById(id);
        ApiResponse<ContactDTO> response = new ApiResponse<>(
                true,
                "Fetched contact details successfully",
                contact
        );
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ContactDTO>> updateContact(
            @PathVariable Long id,
            @Valid @RequestBody ContactDTO contactDTO) {
        ContactDTO updatedContact = contactService.updateContact(id, contactDTO);
        ApiResponse<ContactDTO> response = new ApiResponse<>(
                true,
                "Contact updated successfully",
                updatedContact
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        ApiResponse<Void> response = new ApiResponse<>(
                true,
                "Contact deleted successfully with ID: " + id,
                null
        );
        return ResponseEntity.ok(response);
    }
}
