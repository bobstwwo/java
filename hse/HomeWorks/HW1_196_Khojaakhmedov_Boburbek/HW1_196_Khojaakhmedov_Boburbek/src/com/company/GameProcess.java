/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */
package com.company;

import MyPackage.*;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class GameProcess {
    FieldsCollection<Field> cl = new FieldsCollection<Field>();
    String[][] arr;
    int money;
    double debtCoeff;
    double creditCoeff;
    double penaltyCoeff;

    public GameProcess(String[][] arr, int money, double debtCoeff, double creditCoeff, double penaltyCoeff) {
        this.money = money;
        this.debtCoeff = debtCoeff;
        this.creditCoeff = creditCoeff;
        this.penaltyCoeff = penaltyCoeff;
        this.arr = arr;
    }

    public void Game() {

        out.println("\n\nWelcome to <Just Another Monopolia>");
        Main.printGameBoard(arr);
        Main.printInit(debtCoeff, creditCoeff, penaltyCoeff);

        enter("to start..");

        genColl();

        Gamer pl = new Gamer(money, false);
        Gamer bot = new Gamer(money, true);

        if (genOrder() == 1) {
            playGame(pl, bot, pl);
        } else {
            playGame(pl, bot, bot);
        }
    }

    public int genStep() {
        return Main.rnd(1, 6) + Main.rnd(1, 6);
    }

    /**
     * Find the first roll between the player and the computer
     */
    public int genOrder() {
        int bot = genStep();
        int player = genStep();
        if (player > bot) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Generates the collection of objects of cells
     */
    public void genColl() {
        ArrayList<String> list = Main.getList(arr);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "$")
                cl.Add(new Bank(debtCoeff, creditCoeff));
            if (list.get(i) == "%")
                cl.Add(new PenaltyCell(penaltyCoeff));
            if (list.get(i) == "T")
                cl.Add(new Taxi());
            if (list.get(i) == "E")
                cl.Add(new EmptyCell());
            if (list.get(i) == "S") {
                int N = Main.rnd(50, 500);
                cl.Add(new Shop(Main.rndDouble(0.1, 2), Main.rndDouble(0.1, 1), N, (int) Main.rndDouble(0.5 * N, 0.9 * N)));
            }
        }
    }

    /**
     * Requests the user to press the enter
     * @param str the action of the user
     */
    private void enter(String str) {
        Scanner readInput = new Scanner(System.in);
        String enterkey = "\n>>Press ENTER " + str;
        out.println(enterkey);
        enterkey = readInput.nextLine();
        if (enterkey.equals("")) {
            return;
        }
    }

    /**
     * Printing the board game
     */
    public void printGameBoard() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < cl.list.size(); i++) {
            String val = cl.list.get(i).getValue();
            list.add(val);
        }

        int width = arr[0].length;
        int height = arr.length;
        String[][] listArr = new String[height][width];
        //top
        for (int i = 0; i < width; i++) {
            listArr[0][i] = list.get(i);
        }

        //right
        for (int i = 1; i < height; i++) {
            listArr[i][width - 1] = list.get(i + width - 1);
        }

        //bottom
        int counter = width - 1 + height;
        for (int i = width - 2; i > -1; i--) {
            listArr[height - 1][i] = list.get(counter);
            counter++;
        }

        //left
        counter = width + height - 1 + width - 1;
        for (int i = height - 2; i > 0; i--) {
            listArr[i][0] = list.get(counter);
            counter++;
        }
        Main.printGameBoard(listArr);

    }

    /**
     * Prints to the console the winner
     * @param player winner
     */
    public void finish(Gamer player) {
        if (player.isBot) {
            out.println("\n\nGAME: Congratulations, you are the winner");
            return;
        } else {
            out.println("\n\nGAME: DEFEAT, Computer was a winner");
        }
    }

    /**
     * Main method which describes the gaming process
     * @param player the objects of the player
     * @param bot the objects of the computer
     * @param curr_player current player, who has to move
     */
    public void playGame(Gamer player, Gamer bot, Gamer curr_player) {
        do {
            print(player, bot);
            if (!curr_player.isBot) {
                out.printf("\n>>Player makes a move");

                enter("to make a move..");
                int step = genStep();
                curr_player.position = (curr_player.position + step) % cl.list.size();
                out.printf(">>Player shifted for %d cells", step);
                do {
                    if (cl.list.get(curr_player.position) instanceof Taxi) {
                        int taxiDistance = Main.rnd(3, 5);
                        out.printf("\nTAXI: Player shifted forward by %d cell", taxiDistance);
                        curr_player.position = (curr_player.position + taxiDistance) % cl.list.size();
                        continue;
                    } else {
                        cl.list.get(curr_player.position).mainAction(curr_player);
                        break;
                    }
                } while (true);
                String val = cl.list.get(curr_player.position).getValue();
                printGameBoard();
                cl.list.get(curr_player.position).changeVal(val);
                if (curr_player.money <= 0) {
                    finish(player);
                    break;
                } else {
                    curr_player = bot;
                }
            } else {
                out.printf("\n>>Computer makes a move");
                enter("to continue..");

                int step = genStep();
                curr_player.position = (curr_player.position + step) % cl.list.size();
                out.printf("\n>>Computer shifted for %d cells", step);
                do {
                    if (cl.list.get(curr_player.position) instanceof Taxi) {
                        int taxiDistance = Main.rnd(3, 5);
                        out.printf("\nTAXI: Computer shifted forward by %d cell", taxiDistance);
                        curr_player.position = (curr_player.position + taxiDistance) % cl.list.size();
                        continue;
                    } else {
                        cl.list.get(curr_player.position).mainAction(curr_player);
                        break;
                    }
                } while (true);
                String val = cl.list.get(curr_player.position).getValue();
                printGameBoard();
                cl.list.get(curr_player.position).changeVal(val);
                if (curr_player.money <= 0) {
                    finish(curr_player);
                    break;
                } else {
                    curr_player = player;
                }
            }
        } while (true);

    }
    /**
     * Method which prints the information about the money, loan and spending of the player or computer
     * @param player the objects of the player
     * @param bot the objects of the computer
     */
    public void print(Gamer player, Gamer comp) {
        out.printf("\n" + "PLAYER [P]:" + " Balance ->" + player.money + "   ");
        out.printf("Spending ->" + player.spending + "   ");
        out.printf("Loan ->" + String.format("%.0f", player.loan) + "");

        out.printf("\n" + "COMPUTER [C]:" + " Balance ->" + comp.money + "   ");
        out.printf("Spending ->" + comp.spending + "   ");
        out.printf("Loan ->" + String.format("%.0f", comp.loan) + "\n");

    }
}
