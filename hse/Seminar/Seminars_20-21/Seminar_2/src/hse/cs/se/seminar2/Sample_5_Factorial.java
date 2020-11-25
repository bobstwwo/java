package hse.cs.se.seminar2;

import java.math.BigInteger;

/**
 * TODO: READ this: http://www.dcon.com.br/jd.comment/articles/notes-java/data/numbers/60factorial.html
 * We define 3 separate methods and test them...
 */
public class Sample_5_Factorial {

    private static final int LIMIT = 30; //20;

    public static void main(String[] args) {

        //-- int solution (BAD IDEA BECAUSE ONLY WORKS TO 12).
        int intResult = intFactorial(LIMIT);

        //-- what is the limit for long to fail ? (TODO: find -how long the long type can do work?)
        long longResult = longFactorial(LIMIT);

        BigInteger bigIntegerResult = bigFactorial(LIMIT);

    }

    /**
     * This method calculates factorial using BigInteger class
     *
     * @param limit - the number to calculate factorial for.
     * @return - the result of the factorial calculation.
     */
    private static BigInteger bigFactorial(long limit) {
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= limit; i++) {
            n = n.multiply(BigInteger.valueOf(i));
            System.out.println(i + "! = " + n);
        }
        return n;
    }

    /**
     * This method calculates factorial using int primitives numbers.
     *
     * @param limit - the number to calculate factorial for.
     * @return - the result of the factorial calculation.
     */
    private static int intFactorial(int limit) {
        int fact = 1;
        for (int i = 1; i <= limit; i++) {
            fact *= i;
            System.out.println(i + "! = " + fact);
        }
        return fact;
    }

    private static long longFactorial(long limit) {
        long longFact = 1;
        for (int i = 1; i <= limit; i++) {
            longFact = longFact * i;
            System.out.println(i + "! = " + longFact);
        }
        return longFact;
    }
}
