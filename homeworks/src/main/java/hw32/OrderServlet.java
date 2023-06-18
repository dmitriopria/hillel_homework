package hw32;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/api/product-management/products/*")
public class OrderServlet extends HttpServlet {
    private OrderRepository orderRepository;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) {
        orderRepository = new OrderRepository(new ProductRepository());
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public void destroy() {
        orderRepository = null;
        objectMapper = null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try (InputStream inputStream = request.getInputStream();
             OutputStream outputStream = response.getOutputStream()) {
            Product product = mapProduct(inputStream);
            Order order = orderRepository.addOrder(product);
            processResponseWithOrder(response, outputStream, order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int orderId = parseOrderId(request);
        Order order = orderRepository.getOrderById(orderId);
        try (OutputStream outputStream = response.getOutputStream()) {
            processResponseWithOrder(response, outputStream, order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        int orderId = parseOrderId(request);
        try (InputStream inputStream = request.getInputStream();
             OutputStream outputStream = response.getOutputStream()) {
            Product product = mapProduct(inputStream);
            Order order = orderRepository.modifyOrder(orderId, product);
            processResponseWithOrder(response, outputStream, order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processResponseWithOrder
            (HttpServletResponse response, OutputStream outputStream, Order order) throws IOException {
        byte[] orderAsByte = objectMapper.writeValueAsBytes(order);
        outputStream.write(orderAsByte);
        outputStream.flush();
        response.setContentLength(orderAsByte.length);
        response.setContentType("application/json");
        response.setStatus(200);
    }

    private Product mapProduct(InputStream inputStream) throws IOException {
        JsonNode productJson = objectMapper.readTree(inputStream);
        int productId = productJson.get("id").asInt();
        String productName = productJson.get("name").asText();
        double productCost = productJson.get("cost").asDouble();
        return new Product(productId, productName, productCost);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        int orderId = parseOrderId(request);
        orderRepository.deleteOrder(orderId);
        response.setStatus(201);
    }

    private int parseOrderId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String[] parts = pathInfo.split("/");
        String idAsString = parts[parts.length - 1];
        return Integer.parseInt(idAsString);
    }
}