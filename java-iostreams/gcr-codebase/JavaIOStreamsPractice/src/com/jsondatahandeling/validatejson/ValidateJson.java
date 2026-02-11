package com.jsondatahandeling.validatejson;

import com.fasterxml.jackson.databind.*;

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree("{\"name\":\"Aman\"}");
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}
