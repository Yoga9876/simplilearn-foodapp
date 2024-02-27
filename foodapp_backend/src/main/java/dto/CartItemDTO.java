package dto;

public class CartItemDTO {

    private Long dishId;
    private int quantity;

    // Constructors, getters, and setters

    // Default constructor
    public CartItemDTO() {
        // Default constructor
    }

    // Parameterized constructor
    public CartItemDTO(Long dishId, int quantity) {
        this.dishId = dishId;
        this.quantity = quantity;
    }

    // Getters and setters
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

