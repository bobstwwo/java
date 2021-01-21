package participants;

import org.junit.jupiter.api.Test;
import target.Cart;
import user.Main;

import static org.junit.jupiter.api.Assertions.*;

class PikeTest {

    @Test
    void run() {
        Cart cart = new Cart(0,0);
        Pike cr = new Pike(cart, Main.getRandomDouble(1,10),System.currentTimeMillis());
        boolean result = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(cr.P_CART.x!=0&&cr.P_CART.y!=0)
        {
            result = true;
        }
        assertTrue(result);
    }
}