package MyPackage;

public class PenaltyCell extends Field {
    double penaltyCoeff;
    public String val = "%";

    public PenaltyCell(double penaltyCoeff) {
        this.penaltyCoeff = penaltyCoeff;
    }

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

    @Override
    public String getValue() {
        return val;
    }

    @Override
    public void changeVal(String s) {
        val = "%";
    }
}
