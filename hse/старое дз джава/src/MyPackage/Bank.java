package MyPackage;


import java.util.Scanner;

public class Bank extends Field {
    double debtCoeff;
    double creditCoeff;
    public String val = "$";

    public Bank(double debtCoeff, double creditCoeff) {
        this.debtCoeff = debtCoeff;
        this.creditCoeff = creditCoeff;
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
            System.out.println("\nBank: Hello, Computer");
            System.out.println("Bank: We have no services for you");
            return;
        } else {
            System.out.println("\nBank: Welcome to the bank office.");
            if (player.loan > 0) {
                System.out.println("Bank: Player is a creditor of the bank, his debt is " + String.format("%.3f", player.loan));
                if (player.money < player.loan) {
                    System.out.println("Bank: Player is unable to pay his debt, you lost");
                    player.money = 0;
                    return;
                } else {
                    player.money -= player.loan;
                    player.loan = 0;
                    System.out.println("Bank: Player paid a loan, We're ready for him");
                    return;
                }
            } else {
                if (player.spending > 0) {
                    String val = String.format("%.0f", creditCoeff * player.spending);
                    System.out.println("Bank: Player can take a loan out from us up to " + val + "$");
                    do {
                        System.out.println("Bank: Input the amount of money you would like to get or input `No` to refuse:");
                        String amount = getInput(creditCoeff * player.spending);
                        if (amount == "no") {
                            System.out.println("Bank: You refused to get a credit. See you next time");
                            break;
                        }
                        if (amount == "one") {
                            System.out.println("SHOP: You entered not a number (or a negative number), please, try again");
                            continue;
                        }
                        if (amount == "two") {
                            System.out.println("You entered more than " + val + "(or a negative number) please, try again");
                            continue;
                        }
                        int amount_n = Integer.parseInt(amount);
                        if (amount_n <= creditCoeff * player.spending) {
                            System.out.println("Bank: Congratulation, your credit request is accepted");
                            player.money += amount_n;
                            player.loan = debtCoeff * amount_n;
                            break;
                        }
                    } while (true);
                    return;
                } else {
                    System.out.println("Bank: We're unable to provide you a credit, because you have no spending");
                    return;
                }
            }
        }
    }

    public String getInput(double max) {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        if (result.equals("No"))
            return "no";
        else {
            if (tryParseInt(result)) {
                int n = Integer.parseInt(result);
                if (n > 0 && n <= max) {
                    return String.valueOf(n);
                } else {
                    return "two"; //more than max
                }
            } else {
                return "one"; //not a number
            }
        }
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getValue() {
        return val;
    }

    @Override
    public void changeVal(String s) {
        val = "$";
    }

}
