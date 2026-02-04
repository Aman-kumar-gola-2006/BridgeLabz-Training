package com.annotations.intermediatelevel.maxlength;

public class Test {
    public static void main(String[] args) {
        new User("abhay");        // ✅ OK
     //   new User(null); 
        new User("this_is_too_long"); // ❌ Exception
    }
}
