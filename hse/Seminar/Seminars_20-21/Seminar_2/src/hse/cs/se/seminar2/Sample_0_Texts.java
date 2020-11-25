package hse.cs.se.seminar2;

/**
 * This class is to show some text usages... Show step by step in debug mode...
 */
public class Sample_0_Texts {
    public static void main(String[] args) {
        System.out.println("Hello, World! - from JDK 11..."); // let's speak in English...
        System.out.println("Здравствуйте, ребята..."); // And let's speak in Russian...
        char a = '\u005B';
        char b = '\u005D';
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a = " + (int)a + ", b = " + (int)b);
        System.out.println("a * b = " + a * b);
    }
}
