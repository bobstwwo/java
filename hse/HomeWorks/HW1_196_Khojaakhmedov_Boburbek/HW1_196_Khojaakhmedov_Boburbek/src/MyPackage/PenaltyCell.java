/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */
package MyPackage;

public class PenaltyCell extends Field {
    double penaltyCoeff;
    public String val = "%";

    public PenaltyCell(double penaltyCoeff) {
        this.penaltyCoeff = penaltyCoeff;
    }

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
        if (player.isBot) {
            double penalty = penaltyCoeff * player.money;
            if (player.money > penalty) {
                player.money -= penalty;
                System.out.printf("\nPENALTY: Computer is in PenaltyCell, he is fined for %s$", String.format("%.0f", penalty));
                return;
            } else {
                System.out.println("\nPENALTY: Computer is unable to pay fine for PenaltyCell, he lost");
                player.money = 0;
                return;
            }
        } else {
            double penalty = penaltyCoeff * player.money;
            if (player.money > penalty) {
                player.money -= penalty;
                System.out.printf("\nPENALTY: Player is in PenaltyCell, fined for %s$", String.format("%.3f", penalty));
                return;
            } else {
                System.out.println("\nPENALTY: Player is unable to pay fine for PenaltyCell, you lost");
                player.money = 0;
                return;
            }
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
        val = "%";
    }



}
