/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */
package MyPackage;

public class EmptyCell extends Field {
    public String val = "E";


    /**
     * Method with the main action of the player
     */
    @Override
    public void mainAction(Gamer player) {
        if(player.isBot)
        {
            val = "C";
        }
        else
        {
            val = "P";
        }
        if(player.isBot)
        {
            System.out.println("\nRELAXATION: Computer is in relaxation cell");
            return;
        }
        else {
            System.out.println("\nRELAXATION: Player is in relaxation cell");
            System.out.println("RELAXATION: Just relax there");
            return;
        }
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
        val = "E";
    }
}

