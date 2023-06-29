package hw36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ConsoleProgram {
    private static final Logger LOGGER = Logger.getLogger(ConsoleProgram.class.getName());

    public static void startConsoleProgram(Cart cart, ProductRepository productRepository) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int choice;
            do {
                LOGGER.info("1. Додати товар до кошика");
                LOGGER.info("2. Видалити товар з кошика");
                LOGGER.info("3. Вийти");
                LOGGER.info("Ваш вибір: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1 -> {
                        LOGGER.info("Введіть ID товару, який потрібно додати: ");
                        int productIdToAdd = Integer.parseInt(reader.readLine());
                        productRepository.getProductById(productIdToAdd).ifPresent(cart::addProduct);
                    }
                    case 2 -> {
                        LOGGER.info("Введіть ID товару, який потрібно видалити: ");
                        int productIdToRemove = Integer.parseInt(reader.readLine());
                        cart.removeProductById(productIdToRemove);
                    }
                    case 3 -> LOGGER.info("Програма завершує роботу.");
                    default -> LOGGER.info("Невірний вибір! Виберіть 1, 2 чи 3.");
                }
                LOGGER.info("Поточний стан кошика:");
                for (Product product : cart.getProducts()) {
                    LOGGER.info(product.getId() + " - " + product.getName() + " - " + product.getPrice());
                }
                LOGGER.info("");
            } while (choice != 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
