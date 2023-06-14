package hw21;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsHandler {

    public static List<Product> findExpensiveBooks(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.getPrice() > 250)
                .toList();
    }

    public static List<Product> getBooksWithDiscount(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.hasDiscount())
                .map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                })
                .toList();
    }

    public static Product findCheapestBook(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(Product::isBook)
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Product \"Book\" was not found!"));
    }

    public static List<Product> getLastThreeSupply(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .skip(products.size() - 3)
                .toList();
    }

    public static double sumRequiredPrices(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.isCurrentYearSupply() && product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<ProductType, List<Product>> groupByType(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
