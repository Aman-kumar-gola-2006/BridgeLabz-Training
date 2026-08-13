package com.cjc.contact.repository;

import com.cjc.contact.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA Repository interface for ContactEntity.
 * Provides out-of-the-box CRUD and pagination capabilities.
 */
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    /**
     * Custom query method to find contact by email address.
     */
    Optional<ContactEntity> findByEmail(String email);

    /**
     * Custom check to verify if a contact exists by email.
     */
    boolean existsByEmail(String email);
}
