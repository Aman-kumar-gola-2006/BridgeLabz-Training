package com.jsondatahandeling.createjsonobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class StudentJsonCreate {
    public static void main(String[] args) throws Exception {
        Map<String, Object> student = new LinkedHashMap<>();
        student.put("name", "Aman");
        student.put("age", 22);
        student.put("subjects", Arrays.asList("Maths", "Physics", "Java"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(json);
    }
}
