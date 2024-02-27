package dto;



public class PaymentRequest {

    private Long userId;
    private Double amount;

    // Constructors, getters, and setters

    // Default constructor
    public PaymentRequest() {
        // Default constructor
    }

    // Parameterized constructor
    public PaymentRequest(Long userId, Double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
