package model;

public class CartItem {
    private Long id;
    private Long userId; // User ID associated with this cart item
    private String itemName;
    private double price;
    private int quantity;

    // Constructors, getters, and setters

    public CartItem() {
        // Default constructor
    }

    public CartItem(Long userId, String itemName, double price, int quantity) {
        this.userId = userId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
