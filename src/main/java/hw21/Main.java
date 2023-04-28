package hw21;

import java.time.LocalDate;
import java.util.List;

import static hw21.ProductType.BOOK;
import static hw21.ProductType.TOY;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, BOOK, 75, false, LocalDate.of(2023, 1, 1)),
                new Product(2, TOY, 250, true, LocalDate.of(2023, 2, 15)),
                new Product(3, BOOK, 280, true, LocalDate.of(2023, 3, 10)),
                new Product(4, TOY, 30, false, LocalDate.of(2023, 4, 5)),
                new Product(5, BOOK, 20, true, LocalDate.of(2023, 5, 20))
        );

        System.out.println(ProductsHandler.findExpensiveBooks(products));
        System.out.println(ProductsHandler.getBookDiscount(products));
        System.out.println(ProductsHandler.findCheapestBook(products));
        System.out.println(ProductsHandler.getLastThreeSupply(products));
        System.out.println(ProductsHandler.sumRequiredPrices(products));
        System.out.println(ProductsHandler.groupByType(products));
    }
}
