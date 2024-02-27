package dto;

import java.util.Map;

public class UpdateCartRequest {

    private Long userId;
    private Map<Long, Integer> items; // Map of dishId to quantity

    // Constructors, getters, and setters

    // Default constructor
    public UpdateCartRequest() {
        // Default constructor
    }

    // Parameterized constructor
    public UpdateCartRequest(Long userId, Map<Long, Integer> items) {
        this.userId = userId;
        this.items = items;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }
}
