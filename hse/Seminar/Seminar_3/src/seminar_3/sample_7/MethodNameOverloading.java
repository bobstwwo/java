package seminar_3.sample_7;

/**
 * TODO: ask: which method will be called?
 * ask first, and check the answer by commenting out the previous answer...
 * TODO: comment out doSomething() methods - one by one...
 *
 * What about С# methods calling? Any difference?
 */
public class MethodNameOverloading {

    private static void doSomething(Number b){ System.out.println("method with Number = " + b); }
    private static void doSomething(int i){ System.out.println("method with int" + i); }
    private static void doSomething(short b){ System.out.println("method with short" + b); }
    private static void doSomething(Integer b){ System.out.println("method with Integer"); }
    private static void doSomething(double b){ System.out.println("method with double" + b); }
    private static void doSomething(float b){ System.out.println("method with float" + b); }
    private static void doSomething(byte b){ System.out.println("method with byte"); }
    private static void doSomething(Byte b){ System.out.println("method with Byte"); }
    private static void doSomething(Object b){ System.out.println("method with Object"); }

    public static void main(String[] args){
        byte b = -12;
        doSomething(b);
    }
}
