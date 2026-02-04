package com.annotations.intermediatelevel.maxlength;

import java.lang.reflect.Field;

public class User {

    @MaxLength(10)
    private String username;

    public User(String username) {

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        try {
            Field field = User.class.getDeclaredField("username");
            field.setAccessible(true);

            MaxLength maxLength = field.getAnnotation(MaxLength.class);

            if (maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException(
                        "Username exceeds max length of " + maxLength.value()
                );
            }

            this.username = username;

        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Validation error", e);
        }
    }
}
