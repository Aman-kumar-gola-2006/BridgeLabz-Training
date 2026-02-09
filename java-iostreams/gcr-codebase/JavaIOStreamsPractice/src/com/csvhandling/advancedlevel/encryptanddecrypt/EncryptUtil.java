package com.csvhandling.advancedlevel.encryptanddecrypt;

import java.util.Base64;

public class EncryptUtil {

    public static String encrypt(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static String decrypt(String value) {
        return new String(Base64.getDecoder().decode(value));
    }
}