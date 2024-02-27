package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query method to find orders by status
    List<Order> findByStatus(String status);

    // Custom query method to find orders by user ID
    List<Order> findByUserId(Long userId);
    
  

    // You can add more custom query methods here based on your requirements
}
