/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */
package MyPackage;

public class Gamer {
    public int money;
    public boolean isBot;
    public int spending = 0;
    public int position = 0;
    public double loan;

    public Gamer(int money, boolean isBot) {
        this.money = money;
        this.isBot = isBot;
    }
}
