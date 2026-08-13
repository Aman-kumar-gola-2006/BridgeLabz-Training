package com.cjc.contact.service;

import com.cjc.contact.dto.ContactDTO;
import java.util.List;


public interface ContactService {

   
    ContactDTO createContact(ContactDTO contactDTO);

    
    List<ContactDTO> getAllContacts();

    
    ContactDTO getContactById(Long id);

   
    ContactDTO updateContact(Long id, ContactDTO contactDTO);

    void deleteContact(Long id);
}
