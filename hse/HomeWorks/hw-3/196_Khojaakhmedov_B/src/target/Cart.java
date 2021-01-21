package target;

import user.Main;

/**
 * Класс описывающий саму тележку
 * Известны начальное положение x и y (Получаю через конструктор)
 */
public class Cart {
    public double x, y;

    public Cart(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Основной метод, где описывается синзранизация потоков.
     * Каждый раз определяется значение sleepTime - столько будет спать каждая сузность после сдвига
     * Происходит синхранизация с помощь общей переменной cart. Потому что во время когда тянет одна сущность,
     * другая не иммет доступа к нему. Так как по условию сказана что тянет только один.
     * Происходит вывод информации пользователю о том, что кто сдвинул и куда сдвинул.
     * (Не стал делать вывод каждые 2 секунды, так как за 2 секунды могли быть несколько сдвигов.
     * Поэтому для того чтобы выводить промежуточные изменения, оставил так.)
     * @param cart общая переменная тележка. У каждой сущности есть ссылка на один и тот же Cart
     * @param newX новое значение координаты x
     * @param newY новое значение координаты y
     */
    public void Move(Cart cart, double newX, double newY) {
        int sleepTime = Main.getRandomInt(1000, 5000);
        synchronized (cart) {
            System.out.printf("%s сдинул(а) тележку из (%.2f , %.2f) в (%.2f , %.2f) ", Thread.currentThread().getName(), this.x, this.y, newX, newY);
            System.out.print("- Ушел(a) спать на " + sleepTime + "ms\n");

            this.x = newX;
            this.y = newY;
        }
        try {
            synchronized (this) {
                wait(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted: " + e);
        }
    }

    /**
     * Метод, который выводит информацию о финальной позиции тележки.
     */
    public void showFinalLocation() {
        System.out.printf("\nФинальная позиция (x , y) -> (%.2f , %.2f)", this.x, this.y);
    }
}
