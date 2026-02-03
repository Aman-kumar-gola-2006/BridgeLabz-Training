package com.junit.aftereachandbeforeeach;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

// JUnit 4 lifecycle methods example
public class DatabaseConnectionTest {

    DatabaseConnection db;

    // Runs before every test
    @Before
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    // Runs after every test
    @After
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }
}