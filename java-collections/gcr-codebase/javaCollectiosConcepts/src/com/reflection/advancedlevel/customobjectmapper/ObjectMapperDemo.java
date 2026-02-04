package com.reflection.advancedlevel.customobjectmapper;


import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapperDemo {
	public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {

            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }

        return obj;
        
        
}
	public static void main(String[] args) throws Exception {

        Map<String, Object> data = Map.of(
                "name", "Alice",
                "age", 22
        );

        User user = toObject(User.class, data);
        System.out.println(user);
    }
}