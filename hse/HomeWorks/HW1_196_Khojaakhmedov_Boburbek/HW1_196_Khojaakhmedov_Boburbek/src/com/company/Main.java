/**
 * @author <a href="mailto:bbkhozhaakhmedov_1@edu.hse.ru"> Boburbek Khojaakhmedov</a>
 */

package com.company;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {

    /**
     * Here start point of the program
     *
     * @param args command line value
     */
    public static void main(String[] args) {

        int height = rnd(6, 30);
        int width = rnd(6, 30);
        int money = rnd(500, 15000);

        if (args.length == 3) {
            if (tryParseInt(args[0]) && tryParseInt(args[1]) && tryParseInt(args[2])) {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
                money = Integer.parseInt(args[2]);
                if ((width >= 6 && width <= 30) && (height >= 6 && height <= 30) && (money >= 500 && money <= 15000)) {
                    String arr[][] = fillData(width, height);
                    if (arr != null) {
                        double debtCoeff = rndDouble(1.0, 3.0);
                        double creditCoeff = rndDouble(0.002, 0.2);
                        double penaltyCoeff = rndDouble(0.01, 0.1);

                        GameProcess game = new GameProcess(arr, money, debtCoeff, creditCoeff, penaltyCoeff);

                        game.Game();
                    }
                } else {
                    out.println("Incorrect value of width,height or money.");
                }
            }
        } else {
            out.println("Default values are used.");
            String arr[][] = fillData(width, height);
            if (arr != null) {
                double debtCoeff = rndDouble(1.0, 3.0);
                double creditCoeff = rndDouble(0.002, 0.2);
                double penaltyCoeff = rndDouble(0.01, 0.1);

                GameProcess game = new GameProcess(arr, money, debtCoeff, creditCoeff, penaltyCoeff);

                game.Game();
            }
        }
    }

    /**
     * Method TryParse, returns true if its possible to parse, otherwise false
     *
     * @param value value which was read from console
     */
    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method for printing initial information(debtCoeff,creditCoeff,penaltyCoeff) to console
     */
    public static void printInit(double debtCoeff, double creditCoeff, double penaltyCoeff) {
        out.println("***-----------------------------INFO-----------------------------***");
        out.printf("   debtCoeff ->" + String.format("%.3f", debtCoeff) + "   ");
        out.printf("creditCoeff ->" + String.format("%.3f", creditCoeff) + "   ");
        out.printf("penaltyCoeff ->" + String.format("%.3f", penaltyCoeff));
    }

    /**
     * Return an array with the length equal to width and height
     *
     * @param width  width from user
     * @param height height from user
     */
    public static String[][] fillData(int width, int height) {
        if (width >= 6 && height >= 6) {
            String[][] arr = new String[height][width];
            //EmptyCell
            arr[0][0] = "E";
            arr[0][width - 1] = "E";
            arr[height - 1][0] = "E";
            arr[height - 1][width - 1] = "E";

            //Bank
            arr[0][rnd(1, width - 2)] = "$"; //сверху
            arr[rnd(1, height - 2)][width - 1] = "$"; //справа
            arr[height - 1][rnd(1, width - 2)] = "$"; //снизу
            arr[rnd(1, height - 2)][0] = "$"; //слева


            ArrayList<Integer> top = new ArrayList<>();
            ArrayList<Integer> bottom = new ArrayList<>();
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            refresh(arr, top, bottom, left, right);

            fillCells("T", arr, top, bottom, left, right); //taxi

            refresh(arr, top, bottom, left, right);

            fillCells("%", arr, top, bottom, left, right); //penaltyCells

            fillShop(arr); //shop and " "


            return arr;
        } else {
            return null;
        }
    }

    /**
     * Return random Integer number from min to max
     *
     * @param min min value
     * @param max max value
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Return random double number from min to max
     *
     * @param min min value
     * @param max max value
     */
    public static double rndDouble(double min, double max) {
        return min + (double) (Math.random() * (max - min));
    }

    /**
     * Fills the array [][] with the initial values of cells
     *
     */
    public static void fillCells(String value, String[][] arr, ArrayList<Integer> top, ArrayList<Integer> bottom, ArrayList<Integer> left, ArrayList<Integer> right) {
        int width = arr[0].length;
        int height = arr.length;
        if (rnd(1, 10) <= 5) {
            int index_1 = top.get(rnd(0, top.size() - 1));
            int index_2 = top.get(rnd(0, top.size() - 1));
            if (index_1 != index_2) {
                arr[0][index_1] = value;
                arr[0][index_2] = value;
            } else {
                arr[0][index_1] = value;
            }
        }

        if (rnd(1, 10) >= 5) {
            int index_1 = bottom.get(rnd(0, bottom.size() - 1));
            int index_2 = bottom.get(rnd(0, bottom.size() - 1));
            if (index_1 != index_2) {
                arr[height - 1][index_1] = value;
                arr[height - 1][index_2] = value;
            } else {
                arr[height - 1][index_1] = value;
            }
        }

        if (rnd(1, 10) <= 5) {
            int index_1 = left.get(rnd(0, left.size() - 1));
            int index_2 = left.get(rnd(0, left.size() - 1));
            if (index_1 != index_2) {
                arr[index_1][0] = value;
                arr[index_2][0] = value;
            } else {
                arr[index_1][0] = value;
            }
        }


        if (rnd(1, 10) <= 5) {
            int index_1 = right.get(rnd(0, right.size() - 1));
            int index_2 = right.get(rnd(0, right.size() - 1));
            if (index_1 != index_2) {
                arr[index_1][width - 1] = value;
                arr[index_2][width - 1] = value;
            } else {
                arr[index_1][width - 1] = value;
            }
        }
    }

    /**
     * Rewrites the values O or M (C or P) in shop cells and used for printing the location of the Player or Computer
     *
     */
    public static void refresh(String[][] arr, ArrayList<Integer> top, ArrayList<Integer> bottom, ArrayList<Integer> left, ArrayList<Integer> right) {
        int width = arr[0].length;
        int height = arr.length;

        top.clear();
        bottom.clear();
        left.clear();
        right.clear();

        for (int i = 1; i < width - 1; i++) {
            if (arr[0][i] == null)
                top.add(i);
            if (arr[height - 1][i] == null)
                bottom.add(i);
        }
        for (int i = 1; i < height - 1; i++) {
            if (arr[i][0] == null)
                left.add(i);
            if (arr[i][width - 1] == null)
                right.add(i);
        }
    }

    /**
     * Fills the array [][] with the initial values of shop (S)
     *
     */
    public static void fillShop(String[][] arr) {
        int width = arr[0].length;
        int height = arr.length;

        for (int i = 0; i < width; i++) {
            if (arr[0][i] == null)
                arr[0][i] = "S";
            if (arr[height - 1][i] == null)
                arr[height - 1][i] = "S";
        }

        for (int i = 0; i < height; i++) {
            if (arr[i][0] == null)
                arr[i][0] = "S";
            if (arr[i][width - 1] == null)
                arr[i][width - 1] = "S";
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (arr[i][j] == null)
                    arr[i][j] = " ";
            }
        }
    }

    /**
     * Prints the game board
     * @param arr array with the elements of the cells
     */
    public static void printGameBoard(String[][] arr) {
        out.println("\nPlaying area:");
        int width = arr[0].length;
        int height = arr.length;
        String result = "╔═════╗";
        String footer = "╚═════╝";
        String output = "";
        String s = "       ";
        String space = "";
        for (int i = 0; i < width - 2; i++)
            space += s;

        for (int i = 0; i < height; i++) {

            String tmp = "";
            if (i == 0 || i == height - 1) {
                for (int k = 0; k < width; k++) {
                    tmp += result;
                }
                output += tmp + "\n";
                tmp = "";
                for (int w = 0; w < width; w++) {
                    tmp += body(arr[i][w]);
                }
                output += tmp + "\n";
                tmp = "";
                for (int w = 0; w < width; w++) {
                    tmp += footer;
                }
                output += tmp + "\n";
            } else {
                output += (result + space + result + "\n");
                output += (body(arr[i][0]) + space + body(arr[i][width - 1]) + "\n");
                output += (footer + space + footer + "\n");
            }
        }
        out.println(output);
    }

    /**
     * Additional method used in printing the game board
     * @param symb the value in the cell
     */
    public static String body(String symb) {
        return "║  " + symb + "  ║";
    }

    /**
     * Turns the array[][] to the list
     * @param arr array[][] the the values of the cells
     */
    public static ArrayList<String> getList(String[][] arr) {
        int width = arr[0].length;
        int height = arr.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            list.add(arr[0][i]);
        }
        for (int i = 1; i < height; i++) {
            list.add(arr[i][width - 1]);
        }

        for (int i = width - 2; i > -1; i--) {
            list.add(arr[height - 1][i]);
        }
        for (int i = height - 2; i > 0; i--) {
            list.add(arr[i][0]);
        }
        return list;
    }

}