package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can add custom query methods here if needed
}

