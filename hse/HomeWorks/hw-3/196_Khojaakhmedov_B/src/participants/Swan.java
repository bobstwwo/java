package participants;


import target.Cart;

/**
 * Класс описывает сущность - Лебедь.
 * У этой сущность заранее известные поля:
 * angle - значение угла поворота (У каждой сущности свое значение)
 * start - начала работы программы (У каждой сущности одинаковое значение, передается через конструктор)
 * end - время окончания работы программы или же потоков. Каждая сущность перестает тянуть после 25 секунд от начала тяги.
 * (Я сделал от начала работы программы, думаю ничего страшного.
 * Ради таких простых классов не стал делать общий какой-то родитель (абстрактный) от которого унаследовался бы)
 */
public class Swan implements Runnable {
    public final Cart S_CART;
    private final double ANGLE = Math.toDegrees(60);
    private final double COEFFICIENT;
    private final long END;

    /**
     * Здесь же происхоит start потока и определяется конечное время работы потоков + 25 секунд
     * @param cart Ссылка на один общий объект класса Cart
     * @param coefficient Коэффициент S - у каждой сущности свое, случайно определяется при запуске
     * @param start Начала соревнования - у каждой сущности свое
     */
    public Swan(Cart cart, double coefficient, long start) {
        S_CART = cart;
        this.COEFFICIENT = coefficient;
        this.END = start + 25 * 1000;
        new Thread(this, "Лебедь").start();
    }

    /**
     * Метод интерфейса Runnable
     */
    @Override
    public void run() {
        while (System.currentTimeMillis() < END) {
            double newX = S_CART.x + COEFFICIENT * Math.cos(ANGLE);
            double newY = S_CART.y + COEFFICIENT * Math.sin(ANGLE);
            S_CART.Move(S_CART, newX, newY);
        }
    }
}
