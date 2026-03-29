package com.jazx;

import java.util.*;

/**
 * Discounts based on number of distinct flavors in a set:
 * 2 flavors → 10% discount on that set’s price
 * 3 flavors → 20% discount
 * 4 flavors → 30% discount
 * 5 flavors → 40% discount
 *
 *
 * unitPrice = 10
 * macarons = ["Vanilla", "Vanilla", "Chocolate"]
 * Step-by-step
 * Group into sets:
 * Set 1: Vanilla, Chocolate → 2 flavors → 10% discount
 * Remaining: Vanilla alone → no discount
 * Price:
 * Set 1: 2 × 10 = 20 → discount = 10% → 20 × 0.9 = 18
 * Set 2: 1 × 10 = 10 → no discount
 * Total: 18 + 10 = 28
 * Output
 * 28
 *
 */
public class MacronProblem {

    public static void main(String[] args) {
        System.out.println(calculateMacrorn(new String[] {"Vanilla", "Vanilla", "Chocolate"}, 10));
        System.out.println(calculateMacrorn(new String[] {"Vanilla", "Vanilla", "Apple", "Apple"}, 4));
    }
    private static double calculateMacrorn(String[] orders, int unitPrice){
        Map<String,Integer> countMap = new HashMap();
        for (String orderItem : orders){
            countMap.merge(orderItem,1, Integer::sum);
        }
        double total = 0;
        while (!countMap.isEmpty()) {
            total += calculate(countMap.size(), unitPrice);

            // Reduce counts directly and remove zero entries
            countMap.replaceAll((flavor, count) -> count - 1);
            countMap.values().removeIf(count -> count == 0);
        }
        return total;

    }

    private static double calculate(int size, double unitPrice) {
        double total = size * unitPrice;
        int discount = (size * 10 - 10);
        return discount > 0 ? total - (total*discount)/100 : total;
    }

}
