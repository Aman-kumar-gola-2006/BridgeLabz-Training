package com.junit.aftereachandbeforeeach;

//Simulates a database connection
public class DatabaseConnection {

private boolean connected;

// Opens the connection
public void connect() {
   connected = true;
}

// Closes the connection
public void disconnect() {
   connected = false;
}

public boolean isConnected() {
   return connected;
}
}
