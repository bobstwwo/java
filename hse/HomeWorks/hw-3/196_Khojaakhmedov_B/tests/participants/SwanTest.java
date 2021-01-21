package participants;

import org.junit.jupiter.api.Test;
import target.Cart;
import user.Main;

import static org.junit.jupiter.api.Assertions.*;

class SwanTest {

    @Test
    void run() {
        Cart cart = new Cart(0,0);
        Swan cr = new Swan(cart, Main.getRandomDouble(1,10),System.currentTimeMillis());
        boolean result = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(cr.S_CART.x!=0&&cr.S_CART.y!=0)
        {
            result = true;
        }
        assertTrue(result);
    }
}