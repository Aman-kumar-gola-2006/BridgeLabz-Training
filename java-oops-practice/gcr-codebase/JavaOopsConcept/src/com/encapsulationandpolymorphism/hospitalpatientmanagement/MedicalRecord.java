package com.encapsulationandpolymorphism.hospitalpatientmanagement;

/*
 * MedicalRecord interface
 * -----------------------
 * Any patient having medical records
 * must implement this interface.
 */
public interface MedicalRecord {

    // Adds a medical record entry
    void addRecord(String record);

    // Displays medical history
    void viewRecords();
}

