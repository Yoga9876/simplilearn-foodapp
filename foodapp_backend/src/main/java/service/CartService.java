package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Cart;
import model.CartItem;
import repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(CartItem cartItem) {
        // Retrieve the cart by user ID or create a new cart if it doesn't exist
        Cart cart = cartRepository.findByUserId(cartItem.getUserId());
        if (cart == null) {
            cart = new Cart(cartItem.getUserId());
        }
        // Add the item to the cart
        cart.addItem(cartItem);
        // Save the updated cart to the database
        return cartRepository.save(cart);
    }

    public Cart getCartByUserId(Long userId) {
        // Retrieve the cart by user ID
        return cartRepository.findByUserId(userId);
    }

    public Cart updateCart(Long userId, List<CartItem> cartItems) {
        // Retrieve the cart by user ID
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            return null; // Cart not found
        }
        // Update the cart items
        cart.setItems(cartItems);
        // Save the updated cart to the database
        return cartRepository.save(cart);
    }

    public boolean clearCart(Long userId) {
        // Retrieve the cart by user ID
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            return false; // Cart not found
        }
        // Clear the cart items
        cart.clearItems();
        // Save the updated cart to the database
        cartRepository.save(cart);
        return true;
    }
}
