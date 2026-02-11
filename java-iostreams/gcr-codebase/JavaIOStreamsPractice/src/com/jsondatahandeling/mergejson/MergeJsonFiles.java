package com.jsondatahandeling.mergejson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;

public class MergeJsonFiles {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ArrayNode json1 =
                (ArrayNode) mapper.readTree(new File(
                        "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/jsondatahandeling/mergejson/json1.json"
                ));

        ArrayNode json2 =
                (ArrayNode) mapper.readTree(new File(
                        "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/jsondatahandeling/mergejson/json2.json"
                ));

        // Merge json2 into json1
        json1.addAll(json2);

        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(
                      "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/jsondatahandeling/mergejson/merged.json"
              ), json1);

        System.out.println("JSON files merged successfully!");
    }
}
