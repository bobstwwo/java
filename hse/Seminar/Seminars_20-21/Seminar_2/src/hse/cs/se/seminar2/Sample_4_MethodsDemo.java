package hse.cs.se.seminar2;

//TODO: analyze warnings...

public class Sample_4_MethodsDemo {

    public static void main(String[] args) {
        long res, res1, res2, res3, res4, res5;

        res = m(3, 4);

        res1 = m((int)3, (long) 4);
        res2 = m((long)3, (int) 4);

        res3 = m(3, (long) 4);
        res4 = m((long)3,  4);

        res5 = m(5L, 5L);

        System.out.println(res +", " + res1 + ", " + res2 + ", " + res3 + ", " + res4 + ", " + res5);

    }

    static long m (int a, long b) {
        return  a + b;
    }
    static long m (long a, int b) {
        return  a - b;
    }
    static int m (int a, int b) {
        return a * b;
    }
    static long m (long a, long b) {
        return a * b * 2;
    }
}
