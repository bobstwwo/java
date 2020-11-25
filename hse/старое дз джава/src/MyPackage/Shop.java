package MyPackage;

import main.Main;

import java.util.Scanner;

public class Shop extends Field {
    private Gamer owner;
    public String val = "S";
    double improvementCoeff;
    double compensationCoeff;
    int N;
    int K;
    String M_or_O = "";

    public Shop(double improvementCoeff, double compensationCoeff, int N, int K) {
        this.improvementCoeff = improvementCoeff;
        this.compensationCoeff = compensationCoeff;
        this.N = N;
        this.K = K;
    }

    @Override
    public String getValue() {
        return val;
    }

    @Override
    public void changeVal(String s) {
        if(M_or_O.equals("M")||M_or_O.equals("O"))
            val = M_or_O;
        else
            val = "S";
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
            if (owner == player) {
                System.out.println("\nSHOP: Hello, computer");
                if (Main.rnd(1, 10) <= 8) {
                    if (player.money > N * improvementCoeff) {
                        String sr = String.format("%.0f", N * improvementCoeff);
                        player.spending += N * improvementCoeff;
                        player.money -= N * improvementCoeff;
                        N += (N + improvementCoeff * N);
                        K += (K + K * compensationCoeff);

                        System.out.println("SHOP: Computer upgraded his shop for " + sr);
                        return;
                    }
                } else {
                    System.out.println("SHOP: Computer refused to upgrade his shop");
                    return;
                }
            }
            if (owner == null) {
                if (Main.rnd(1, 10) <= 7) {
                    System.out.println("\nSHOP: Hello, computer");
                    System.out.println("SHOP: I have no owner");
                    if (player.money > N) {
                        player.money -= N;
                        player.spending += N;
                        owner = player;
                        val = "O";
                        M_or_O = "O";
                        System.out.printf("SHOP: Computer bought a shop for %d", N);
                        return;
                    } else {
                        System.out.println("SHOP: Computer has no enough money to buy");
                        return;
                    }
                } else {
                    System.out.println("\nSHOP: Computer refused to buy");
                    return;
                }
            }
            if (owner != player) {
                System.out.println("\nSHOP: Hello, computer");
                System.out.printf("SHOP: You have to pay %d$ of compensation", K);
                if (player.money > K) {
                    System.out.println("\nSHOP: Thanks for paying a compensation");
                    player.money -= K;
                    owner.money += K;
                    return;
                } else {
                    System.out.println("\nSHOP: Computer has no enough money, he lost");
                    player.money = 0;
                    return;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        if (owner == player) {
            System.out.println("\nSHOP: Welcome to shop center");
            String new_imp_price = String.format("%.0f", N * improvementCoeff);
            System.out.printf("SHOP: Would you like to upgrade it for %s$? Input ‘Yes’ if you agree or ‘No’ otherwise.", new_imp_price);
            if (getInputStr()) {
                if (player.money > N * improvementCoeff) {
                    player.spending += N * improvementCoeff;
                    player.money -= N * improvementCoeff;
                    N += (N + improvementCoeff * N);
                    K += (K + K * compensationCoeff);

                    System.out.println("SHOP: Congratulations, you upgraded your shop");
                    return;
                } else {
                    System.out.println("SHOP: You have no enough money to upgrade");
                    return;
                }
            } else {
                System.out.println("SHOP: You refused to upgrade.");
                return;
            }
        }
        if (owner == null) {
            System.out.println("\nSHOP: Welcome to shop center. This shop has no owner");
            System.out.printf("SHOP: Would you like to buy it for %d$? Input ‘Yes’ if you agree or ‘No’ otherwise.", N);
            if (getInputStr()) {
                if (player.money > N) {
                    player.money -= N;
                    player.spending += N;
                    owner = player;
                    val = "M";
                    M_or_O = "M";
                    System.out.println("SHOP: Congratulations, you bought a shop");
                    return;
                } else {
                    System.out.println("SHOP: You have no enough money");
                    return;
                }
            } else {
                System.out.println("SHOP: You refused to buy");
                return;
            }
        }
        if (owner != player) {
            System.out.printf("\nSHOP: Welcome to opponent`s shop. You have to pay %d$ of compensation", K);
            if (player.money > K) {
                System.out.println("\nSHOP: You paid a compensation");
                player.money -= K;
                owner.money += K;
                return;
            } else {
                System.out.println("\nSHOP: You have no enough money, you lost");
                player.money = 0;
                return;
            }
        }
    }

    public Boolean getInputStr() {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        if (result.equals("Yes"))
            return true;
        else return false;
    }


}
