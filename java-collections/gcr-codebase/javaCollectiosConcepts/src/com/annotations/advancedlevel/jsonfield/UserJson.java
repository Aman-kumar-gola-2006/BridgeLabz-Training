package com.annotations.advancedlevel.jsonfield;

import java.lang.reflect.Field;

public class UserJson {

    @JsonField(name = "user_name")
    private String username = "Abhay";

    public static void main(String[] args) throws Exception {
        UserJson user = new UserJson();
        StringBuilder json = new StringBuilder("{");

        for (Field f : user.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                f.setAccessible(true);
                JsonField jf = f.getAnnotation(JsonField.class);
                json.append("\"").append(jf.name()).append("\":\"")
                    .append(f.get(user)).append("\"");
            }
        }
        json.append("}");
        System.out.println(json);
    }
}