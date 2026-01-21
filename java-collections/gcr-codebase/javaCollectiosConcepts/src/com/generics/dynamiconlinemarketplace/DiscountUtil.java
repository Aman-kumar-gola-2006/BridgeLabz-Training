package com.generics.dynamiconlinemarketplace;

/*
 * Utility class containing generic methods
 */
class DiscountUtil {

    /*
     * Generic method to apply discount
     * Bounded type parameter ensures only Product types are accepted
     */
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}
