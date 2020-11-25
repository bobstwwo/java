package main;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        int height = 6;
        int width = 6;
        String arr[][] = fillData(width, height);
        if (arr != null) {
            int money = 500;
            double debtCoeff = rndDouble(1.0, 3.0);
            double creditCoeff = rndDouble(0.002, 0.2);
            double penaltyCoeff = rndDouble(0.01, 0.1);

            GameProcess game = new GameProcess(arr, money, debtCoeff, creditCoeff, penaltyCoeff);

            game.Game();
        }
    }

    public static void printInit(double debtCoeff, double creditCoeff, double penaltyCoeff) {
        out.println("***━━━━━━━━━━━━━━━━━━━━━━━━━━━━━INFO━━━━━━━━━━━━━━━━━━━━━━━━━━━━━***");
        out.printf("   debtCoeff ➺" + String.format("%.3f", debtCoeff) + "   ");
        out.printf("creditCoeff ➺" + String.format("%.3f", creditCoeff) + "   ");
        out.printf("penaltyCoeff ➺" + String.format("%.3f", penaltyCoeff));
    }

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

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static double rndDouble(double min, double max) {
        return min + (double) (Math.random() * (max - min));
    }

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

    public static String body(String symb) {
        return "║  " + symb + "  ║";
    }

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
//        for (int i = 0; i < list.size(); i++) {
//            out.print(list.get(i) + " ");
//        }
        return list;
    }

}