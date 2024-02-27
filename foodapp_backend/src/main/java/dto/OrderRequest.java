package dto;

import java.util.List;

public class OrderRequest {

    private Long userId;
    private List<Long> dishIds;

    // Constructors, getters, and setters

    // Default constructor
    public OrderRequest() {
        // Default constructor
    }

    // Parameterized constructor
    public OrderRequest(Long userId, List<Long> dishIds) {
        this.userId = userId;
        this.dishIds = dishIds;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getDishIds() {
        return dishIds;
    }

    public void setDishIds(List<Long> dishIds) {
        this.dishIds = dishIds;
    }
}

