package com.reflection.advancedlevel.convertobjecttojson;

import java.lang.reflect.Field;

public class JsonGenerator {
	public static String toJson(Object obj) throws Exception {

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        StringBuilder json = new StringBuilder("{");

        for (Field field : fields) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\":");

            Object value = field.get(obj);
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }
            json.append(",");
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) throws Exception {

        Employee emp = new Employee("Bob", 30);
        System.out.println(toJson(emp));
    }
}