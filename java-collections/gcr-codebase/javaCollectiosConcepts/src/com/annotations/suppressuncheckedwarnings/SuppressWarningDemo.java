package com.annotations.suppressuncheckedwarnings;

import java.util.ArrayList;

public class SuppressWarningDemo {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {

        // Raw type ArrayList (no generics )
        ArrayList list = new ArrayList();

        list.add("Java");
        list.add(100);

        System.out.println(list);
    }
}