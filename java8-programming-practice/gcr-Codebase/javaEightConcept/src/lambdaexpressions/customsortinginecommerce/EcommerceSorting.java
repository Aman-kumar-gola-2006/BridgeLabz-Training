package lambdaexpressions.customsortinginecommerce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EcommerceSorting {

    public static void main(String[] args) {

        // Creating product list (this is our data source)
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Laptop", 60000, 4.5, 10));
        products.add(new Product(2, "Phone", 30000, 4.2, 15));
        products.add(new Product(3, "Tablet", 20000, 4.0, 20));
        products.add(new Product(4, "Headphones", 5000, 4.8, 5));

        // Sorting criteria can change based on business campaign
        String sortBy = "PRICE";

        /*
         * We identify sorting as a changing behavior.
         * Instead of creating multiple comparator classes,
         * we use lambda expressions for dynamic sorting.
         */
        switch (sortBy) {

            case "PRICE" ->
                // Sort products by price in ascending order (Low to High)
                products.sort(Comparator.comparingDouble(p -> p.price));

            case "RATING" ->
                // Sort products by rating in descending order (High to Low)
                products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));

            case "DISCOUNT" ->
                // Sort products by discount in descending order (High to Low)
                products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));

            case "NAME" ->
                // Sort products alphabetically by name (A to Z)
                products.sort(Comparator.comparing(p -> p.name));
        }

        // Display the sorted result
        System.out.println("Products sorted by: " + sortBy);
        products.forEach(System.out::println);
    }
}
