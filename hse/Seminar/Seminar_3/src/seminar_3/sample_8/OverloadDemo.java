package seminar_3.sample_8;

/**
 * TODO: Method name overloading demo
 */
public class OverloadDemo {

    void test () {
        System.out.println("...without parameters...");
    }
    void test(int a) {
        System.out.println ("a: " + a);
    }
    void test(int a, int b) {
        System.out.println ("a and b: " + a + " " + b) ;
    }
    double test(double a) { System.out.println("double a:  " + a);return a * a; }
    void test(byte b, short s){
        System.out.println("test(b,s): " + b + " " + s);
    }
    void test(short s, byte b){
        System.out.println("test(s,b): " + s + " " + b);
    }
}

class Overload {

    public static void main(String args[]) {
        // TODO: what will be called and why?
        OverloadDemo ob = new OverloadDemo() ;
        double result;
        ob.test () ;
        ob.test (10);
        ob.test (10, 20);
        result = ob.test(123.25) ;

        ob.test(1.5F);
        ob.test((byte)3);

        byte b = (byte)5;
        short s = (short)7;

//        ob.test(b, b);    // TODO: explain - what's a problem ???
        ob.test((short) b, b);    // TODO: now - no problem...
        ob.test(s, b);
        ob.test(b, s);

        System.out.println("Result ob.test(123.25) : " + result);
    }
}



