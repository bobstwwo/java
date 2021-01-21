/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */
package MyPackage;

public class Taxi extends Field {
    public String val = "T";

    public Taxi() {
    }

    /**
     * Returns the value of the cell
     */
    @Override
    public String getValue() {
        return val;
    }
    /**
     * Changes the value of the cell
     */
    @Override
    public void changeVal(String s) {
        val = "T";
    }
    /**
     * Method with the main action of the player
     */
    @Override
    public void mainAction(Gamer player) {

    }
}
