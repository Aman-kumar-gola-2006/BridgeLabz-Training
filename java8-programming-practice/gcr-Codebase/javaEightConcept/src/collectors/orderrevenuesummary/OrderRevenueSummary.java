package collectors.orderrevenuesummary;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Alice", 1200),
                new Order("Bob", 800),
                new Order("Alice", 500),
                new Order("Bob", 700),
                new Order("Charlie", 1000)
        );

       Map<String, Double> revenueByCustomer = orders.stream().collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Order::getOrderAmount)));
       revenueByCustomer.forEach((name,total)->System.out.println("Customer:"+ name + "->" + total ));
    }
}
