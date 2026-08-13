package com.cjc.contact;

import com.cjc.contact.dto.ContactDTO;
import com.cjc.contact.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactAppApplicationTests {

    @Autowired
    private ContactService contactService;

    @Test
    void contextLoads() {
        assertNotNull(contactService);
    }

    @Test
    void testH2DatabaseSeedDataLoaded() {
        List<ContactDTO> contacts = contactService.getAllContacts();
        assertNotNull(contacts);
        assertFalse(contacts.isEmpty(), "Seed data from data.sql should be loaded into H2 Database");
        assertTrue(contacts.stream().anyMatch(c -> c.getName().equals("Rahul Sharma")));
    }

    @Test
    void testCreateAndFetchContactInH2() {
        ContactDTO newContact = new ContactDTO(null, "Suresh Kumar", "suresh.kumar@example.com", "9812345678", "Work");
        ContactDTO created = contactService.createContact(newContact);

        assertNotNull(created.getId());
        assertEquals("Suresh Kumar", created.getName());

        ContactDTO fetched = contactService.getContactById(created.getId());
        assertEquals("suresh.kumar@example.com", fetched.getEmail());
    }
}
