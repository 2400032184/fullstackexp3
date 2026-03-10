package com.hibernate;

import com.hibernate.dao.ProductDAO;
import com.hibernate.entity.Product;
import com.hibernate.util.HibernateUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        // Insert 8 sample products
        insertSampleProducts(dao);

        System.out.println("\n========== TASK 3a: Sort by Price Ascending ==========");
        List<Product> priceAsc = dao.sortByPriceAscending();
        priceAsc.forEach(System.out::println);

        System.out.println("\n========== TASK 3b: Sort by Price Descending ==========");
        List<Product> priceDesc = dao.sortByPriceDescending();
        priceDesc.forEach(System.out::println);

        System.out.println("\n========== TASK 4: Sort by Quantity (Highest First) ==========");
        List<Product> quantitySort = dao.sortByQuantityHighestFirst();
        quantitySort.forEach(System.out::println);

        System.out.println("\n========== TASK 5a: Pagination - First 3 Products ==========");
        List<Product> first3 = dao.getFirstThreeProducts();
        first3.forEach(System.out::println);

        System.out.println("\n========== TASK 5b: Pagination - Next 3 Products ==========");
        List<Product> next3 = dao.getNextThreeProducts();
        next3.forEach(System.out::println);

        System.out.println("\n========== TASK 6a: Count Total Products ==========");
        long totalCount = dao.countTotalProducts();
        System.out.println("Total Products: " + totalCount);

        System.out.println("\n========== TASK 6b: Count Products with Quantity > 0 ==========");
        long countWithQty = dao.countProductsWithQuantity();
        System.out.println("Products with Quantity > 0: " + countWithQty);

        System.out.println("\n========== TASK 6c: Count Products Grouped by Description ==========");
        List<Object[]> groupedCount = dao.countProductsGroupedByDescription();
        for (Object[] row : groupedCount) {
            System.out.println("Description: " + row[0] + ", Count: " + row[1]);
        }

        System.out.println("\n========== TASK 6d: Min and Max Price ==========");
        Object[] minMax = dao.findMinMaxPrice();
        System.out.println("Min Price: " + minMax[0] + ", Max Price: " + minMax[1]);

        System.out.println("\n========== TASK 7: Group by Description ==========");
        List<Object[]> grouped = dao.groupByDescription();
        for (Object[] row : grouped) {
            System.out.println("Description: " + row[0] + ", Count: " + row[1]);
        }

        System.out.println("\n========== TASK 8: Filter by Price Range (100-500) ==========");
        List<Product> priceRange = dao.filterByPriceRange(100, 500);
        priceRange.forEach(System.out::println);

        System.out.println("\n========== TASK 9a: Names Starting with 'L' ==========");
        List<Product> startsWith = dao.findProductsStartingWith("L");
        startsWith.forEach(System.out::println);

        System.out.println("\n========== TASK 9b: Names Ending with 'e' ==========");
        List<Product> endsWith = dao.findProductsEndingWith("e");
        endsWith.forEach(System.out::println);

        System.out.println("\n========== TASK 9c: Names Containing 'top' ==========");
        List<Product> contains = dao.findProductsContaining("top");
        contains.forEach(System.out::println);

        System.out.println("\n========== TASK 9d: Names with Length 5 ==========");
        List<Product> byLength = dao.findProductsByNameLength(5);
        byLength.forEach(System.out::println);

        HibernateUtil.shutdown();
    }

    private static void insertSampleProducts(ProductDAO dao) {
        Product[] products = {
            new Product("Laptop", 899.99, 15, "Electronics"),
            new Product("Mouse", 29.99, 50, "Electronics"),
            new Product("Keyboard", 79.99, 30, "Electronics"),
            new Product("Monitor", 299.99, 10, "Electronics"),
            new Product("Desk", 199.99, 5, "Furniture"),
            new Product("Chair", 149.99, 8, "Furniture"),
            new Product("Lamp", 49.99, 0, "Furniture"),
            new Product("Phone", 699.99, 20, "Electronics")
        };

        for (Product product : products) {
            dao.insertProduct(product);
        }
        System.out.println("8 sample products inserted successfully!");
    }
}
