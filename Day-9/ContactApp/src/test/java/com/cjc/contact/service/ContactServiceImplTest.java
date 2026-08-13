package com.cjc.contact.service;

import com.cjc.contact.dto.ContactDTO;
import com.cjc.contact.entity.ContactEntity;
import com.cjc.contact.exception.ContactNotFoundException;
import com.cjc.contact.repository.ContactRepository;
import com.cjc.contact.service.impl.ContactServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    private ContactEntity contactEntity;
    private ContactDTO contactDTO;

    @BeforeEach
    void setUp() {
        contactEntity = new ContactEntity(1L, "Rahul Sharma", "rahul@example.com", "9876543210", "Work");
        contactDTO = new ContactDTO(1L, "Rahul Sharma", "rahul@example.com", "9876543210", "Work");
    }

    @Test
    void testCreateContact_Success() {
        // Given
        when(contactRepository.save(any(ContactEntity.class))).thenReturn(contactEntity);

        // When
        ContactDTO created = contactService.createContact(contactDTO);

        // Then
        assertNotNull(created);
        assertEquals(1L, created.getId());
        assertEquals("Rahul Sharma", created.getName());
        assertEquals("rahul@example.com", created.getEmail());
        verify(contactRepository, times(1)).save(any(ContactEntity.class));
    }

    @Test
    void testGetAllContacts_Success() {
        // Given
        ContactEntity contact2 = new ContactEntity(2L, "Priya Verma", "priya@example.com", "9123456789", "Personal");
        when(contactRepository.findAll()).thenReturn(Arrays.asList(contactEntity, contact2));

        // When
        List<ContactDTO> contacts = contactService.getAllContacts();

        // Then
        assertNotNull(contacts);
        assertEquals(2, contacts.size());
        assertEquals("Rahul Sharma", contacts.get(0).getName());
        assertEquals("Priya Verma", contacts.get(1).getName());
        verify(contactRepository, times(1)).findAll();
    }

    @Test
    void testGetContactById_Success() {
        // Given
        when(contactRepository.findById(1L)).thenReturn(Optional.of(contactEntity));

        // When
        ContactDTO result = contactService.getContactById(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Rahul Sharma", result.getName());
        verify(contactRepository, times(1)).findById(1L);
    }

    @Test
    void testGetContactById_NotFound() {
        // Given
        when(contactRepository.findById(99L)).thenReturn(Optional.empty());

        // When & Then
        ContactNotFoundException exception = assertThrows(
                ContactNotFoundException.class,
                () -> contactService.getContactById(99L)
        );

        assertEquals("Contact not found with ID: 99", exception.getMessage());
        verify(contactRepository, times(1)).findById(99L);
    }

    @Test
    void testUpdateContact_Success() {
        // Given
        ContactDTO updatedInfo = new ContactDTO(1L, "Rahul Updated", "rahul.new@example.com", "9876543210", "Work");
        ContactEntity updatedEntity = new ContactEntity(1L, "Rahul Updated", "rahul.new@example.com", "9876543210", "Work");

        when(contactRepository.findById(1L)).thenReturn(Optional.of(contactEntity));
        when(contactRepository.save(any(ContactEntity.class))).thenReturn(updatedEntity);

        // When
        ContactDTO result = contactService.updateContact(1L, updatedInfo);

        // Then
        assertNotNull(result);
        assertEquals("Rahul Updated", result.getName());
        assertEquals("rahul.new@example.com", result.getEmail());
        verify(contactRepository, times(1)).findById(1L);
        verify(contactRepository, times(1)).save(any(ContactEntity.class));
    }

    @Test
    void testUpdateContact_NotFound() {
        // Given
        when(contactRepository.findById(99L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(
                ContactNotFoundException.class,
                () -> contactService.updateContact(99L, contactDTO)
        );

        verify(contactRepository, times(1)).findById(99L);
        verify(contactRepository, never()).save(any(ContactEntity.class));
    }

    @Test
    void testDeleteContact_Success() {
        // Given
        when(contactRepository.existsById(1L)).thenReturn(true);
        doNothing().when(contactRepository).deleteById(1L);

        // When
        contactService.deleteContact(1L);

        // Then
        verify(contactRepository, times(1)).existsById(1L);
        verify(contactRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteContact_NotFound() {
        // Given
        when(contactRepository.existsById(99L)).thenReturn(false);

        // When & Then
        assertThrows(
                ContactNotFoundException.class,
                () -> contactService.deleteContact(99L)
        );

        verify(contactRepository, times(1)).existsById(99L);
        verify(contactRepository, never()).deleteById(anyLong());
    }
}
