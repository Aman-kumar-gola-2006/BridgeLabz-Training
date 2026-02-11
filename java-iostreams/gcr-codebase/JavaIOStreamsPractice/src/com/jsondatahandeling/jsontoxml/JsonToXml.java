package com.jsondatahandeling.jsontoxml;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class JsonToXml {

    public static void main(String[] args) throws Exception {

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        Object obj = jsonMapper.readValue(
                new File(
                    "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/jsondatahandeling/jsontoxml/student.json"
                ),
                Object.class
        );

        xmlMapper.writeValue(
                new File(
                    "/Users/macbookair/Desktop/Al/JAVA WORKSPACE/java-iostreams/gcr-codebase/JavaIOStreamsPractice/src/com/jsondatahandeling/jsontoxml/student.xml"
                ),
                obj
        );

        System.out.println(" JSON converted to XML successfully!");
    }
}
