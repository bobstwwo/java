package user;

import org.junit.jupiter.api.Test;
import target.Cart;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test_getRandomDouble() {
        double min = 1;
        double max = 10;
        boolean result = false;
        if (Main.getRandomDouble(min, max) >= 1 && Main.getRandomDouble(min, max) < 10) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    void test_getRandomInt() {
        boolean result = false;
        if (Main.getRandomInt(1, 10) >= 1 && Main.getRandomInt(1, 10) < 10) {
            result = true;
        }
        assertTrue(result);
    }


    @Test
    void test_tossUp_n1() {
        int n = 1;
        boolean result = false;
        Cart cart = new Cart(0, 0);
        Main.tossUp(n, cart);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (cart.x != 0 && cart.y != 0) {
            result = true;
        }
        assertTrue(result);
    }
    @Test
    void test_tossUp_n2() {
        int n = 2;
        boolean result = false;
        Cart cart = new Cart(0, 0);
        Main.tossUp(n, cart);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (cart.x != 0 && cart.y != 0) {
            result = true;
        }
        assertTrue(result);
    }
    @Test
    void test_tossUp_n3() {
        int n = 3;
        boolean result = false;
        Cart cart = new Cart(0, 0);
        Main.tossUp(n, cart);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (cart.x != 0 && cart.y != 0) {
            result = true;
        }
        assertTrue(result);
    }

}