package com.jsondatahandeling.convertjavaobject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Toyota", 2022);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(car));
    }
}
