package dto;

public class AddToCartRequest {

    private Long userId;
    private Long dishId;
    private int quantity;

    // Constructors
    public AddToCartRequest() {
        // Default constructor
    }

    public AddToCartRequest(Long userId, Long dishId, int quantity) {
        this.userId = userId;
        this.dishId = dishId;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

