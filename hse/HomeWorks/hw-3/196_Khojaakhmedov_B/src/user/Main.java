package user;

import participants.Crayfish;
import participants.Pike;
import participants.Swan;
import target.Cart;

import java.util.Random;


public class Main {
    /**
     * Точка входа в программу, где происходит считывание координат x0, y0
     * В методе создается экземпляр класса Cart(Тележка)
     * Вызывается метод tossUp()
     * @param args входные параметр при запуске с консольной строки
     */
    public static void main(String[] args) {
        double x = 0;
        double y = 0;
        if (args.length == 2) {
            try {
                x = Double.parseDouble(args[0]);
                y = Double.parseDouble(args[1]);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (args.length == 1) {
            try {
                x = Double.parseDouble(args[0]);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        Cart cart = new Cart(x, y);
        tossUp(getRandomInt(1, 4), cart);
    }

    /**
     * @param leftLimit  нижний лимит
     * @param rightLimit вверхный лимит
     * @return число типа double от нижнего лимита до вверхнего
     */
    public static double getRandomDouble(double leftLimit, double rightLimit) {
        return leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
    }

    /**
     * @param leftLimit  нижний лимит
     * @param rightLimit вверхный лимит
     * @return число типа Int от нижнего лимита до вверхнего
     */
    public static int getRandomInt(int leftLimit, int rightLimit) {
        return (int) ((Math.random() * (rightLimit - leftLimit)) + leftLimit);
    }

    /**
     * Этот метод нужен для того чтобы начало работы потоков было правильным и случайным.
     * Потому что при создании объекта класса - сразу запустается поток в констукторе.
     * Почему я рассмотрел только 3 случая? Потому что остальные случаи и так случайны.
     * То есть, если я создам объект класса Swan(Лебедь) - лебедь потянет первым, а 2 следующих случайным образов.
     * Так как это потоку)) Вот, для того чтобы и начала было случайным - сделан этот метод.
     * @param n    случайное число от 1 до 3 включительно
     * @param cart объект класса Cart - только один для всех трех сущностей
     */
    public static void tossUp(int n, Cart cart) {
        double s_coefficient = getRandomDouble(1, 10);
        double p_coefficient = getRandomDouble(1, 10);
        double c_coefficient = getRandomDouble(1, 10);
        switch (n) {
            case 1:
                new Crayfish(cart, c_coefficient, System.currentTimeMillis());
                new Swan(cart, s_coefficient, System.currentTimeMillis());
                new Pike(cart, p_coefficient, System.currentTimeMillis());
                break;
            case 2:
                new Pike(cart, p_coefficient, System.currentTimeMillis());
                new Crayfish(cart, c_coefficient, System.currentTimeMillis());
                new Swan(cart, s_coefficient, System.currentTimeMillis());
                break;
            case 3:
                new Swan(cart, s_coefficient, System.currentTimeMillis());
                new Pike(cart, p_coefficient, System.currentTimeMillis());
                new Crayfish(cart, c_coefficient, System.currentTimeMillis());
                break;
            default:
                break;
        }
    }
}
