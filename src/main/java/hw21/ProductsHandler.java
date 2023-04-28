package hw21;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductsHandler {

    public static List<Product> findExpensiveBooks(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.getPrice() > 250)
                .toList();
    }

    public static List<Product> getBookDiscount(List<Product> products) {
        Objects.requireNonNull(products);
        return products.stream()
                .filter(product -> product.isBook() && product.isDiscount())
                .peek(product -> product.setPrice(product.getPrice() * 0.9))
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
                .sorted(Comparator.comparing(Product::getSupplyDate).reversed())
                .limit(3)
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
