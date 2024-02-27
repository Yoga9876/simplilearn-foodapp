package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dto.PaymentRequest;
import model.Payment;
import repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Method to process payment
    public boolean processPayment(PaymentRequest paymentRequest) {
        // Add your payment processing logic here
        // For demonstration purposes, let's assume the payment is successful
        Payment payment = new Payment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setStatus("Success");
        // Save the payment details to the database
        paymentRepository.save(payment);
        return true;
    }
}
