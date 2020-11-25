package MyPackage;

public class Taxi extends Field {
    public String val = "T";

    public Taxi() {
    }

    @Override
    public String getValue() {
        return val;
    }

    @Override
    public void changeVal(String s) {
        val = "T";
    }

    @Override
    public void mainAction(Gamer player) {

    }
}
