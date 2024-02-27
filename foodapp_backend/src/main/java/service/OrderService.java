package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dto.OrderRequest;
import model.Order;
import repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        // Logic to create an Order from OrderRequest and save it
        Order order = new Order(); // Convert OrderRequest to Order
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        // Logic to retrieve orders by user ID
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderById(Long orderId) {
        // Logic to retrieve an order by ID
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElse(null);
    }

    public List<Order> getAllOrders() {
        // Logic to retrieve all orders
        return orderRepository.findAll();
    }

    public Order updateOrder(Long orderId, OrderRequest orderRequest) {
        // Logic to update an existing order with details from OrderRequest
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();
            // Update order fields from orderRequest
            return orderRepository.save(orderToUpdate);
        }
        return null;
    }

    public boolean cancelOrder(Long orderId) {
        // Logic to cancel an order
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }
}