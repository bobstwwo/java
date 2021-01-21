package target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    public double x, y;

    @BeforeEach
    void setUp() {
        this.x = 0;
        this.y = 0;
    }

    @Test
    void move() {
        Cart cart = new Cart(x, y);
        double newX = 2;
        double newY = 3;
        boolean result = false;
        cart.Move(cart, newX, newY);
        if (cart.x == newX && cart.y == newY)
        {
            result = true;
        }
        assertTrue(result);
    }
}