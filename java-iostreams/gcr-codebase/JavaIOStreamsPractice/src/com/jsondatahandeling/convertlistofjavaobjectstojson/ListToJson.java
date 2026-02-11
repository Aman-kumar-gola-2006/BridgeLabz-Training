package com.jsondatahandeling.convertlistofjavaobjectstojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<Car> cars = Arrays.asList(
                new Car("BMW", 2020),
                new Car("Audi", 2021)
        );

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(cars));
    }
}
