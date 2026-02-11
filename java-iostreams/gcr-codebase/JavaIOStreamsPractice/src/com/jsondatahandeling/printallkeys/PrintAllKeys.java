package com.jsondatahandeling.printallkeys;

import com.fasterxml.jackson.databind.*;
import java.io.File;
import java.util.Iterator;

public class PrintAllKeys {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/jsondatahandeling/printallkeys/users.json"));

        for (JsonNode obj : node) {
            Iterator<String> keys = obj.fieldNames();
            while (keys.hasNext()) {
                String k = keys.next();
                System.out.println(k + " : " + obj.get(k));
            }
        }
    }
}
