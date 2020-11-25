package MyPackage;

public class EmptyCell extends Field {
    public String val = "E";
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
    @Override
    public String getValue() {
        return val;
    }

    @Override
    public void changeVal(String s) {
        val = "E";
    }
}

