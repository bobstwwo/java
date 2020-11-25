package hse.cs.se.seminar2;

import java.math.BigDecimal;

public class Sample_1_Primitives {

    public static void main(String[] args) {
        System.out.println("7F/0F = " + 7F / 0F);
        System.out.println("-5F/0F = " + (-5F / 0F));
        System.out.println("0F/0F = " + 0F / 0F);

        System.out.println("7F/0F == 5F/0F ? " + (7F / 0F == 5F / 0F));

        try {
            System.out.println("7/0 == 5/0 ? " + (7 / 0 == 5 / 0));
        } catch (Exception ex) {
            System.out.println("exception: " + ex);
        }

        System.out.println("7F/0F == 0F/0F ? " + (7F / 0F == 0F / 0F));

        System.out.println(2.0 - 1.1);
        BigDecimal a = BigDecimal.valueOf(2.0);
        BigDecimal b = BigDecimal.valueOf(1.1);
        System.out.println(a.subtract(b));

        System.out.println("\u03C0 = 3.14159");
        char c1 = '\u03C0';
        System.out.println('\u03C0');
        System.out.println(c1);

        char c2 = '\u005B';
        char c3 = '\u005D';
        System.out.println("\u005B");
        System.out.println("\u005D");
        System.out.println(c2);
        System.out.println(c3);
        System.out.println("\ua42F");

        float f1 = 10f;
        float f2 = 10.1F;
        float f3 = 10.1f;
//        byte b = 10b;
        double ddd = 10F;
        int x = 9;
//        int y = !x;
    }

}
