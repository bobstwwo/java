package seminar_3.sample_10;

//import java.util.Vector;

/**
 * TODO: try to force GC to work before the program exits...
 * TODO: Note: we do not see finalize() calls in JDK 11, but if we change our Project language level to JDK 8 - it is called and works...
 * (it means that GC is reimplemented since JDK8...)
 * https://medium.com/expedia-group-tech/what-to-do-about-the-garbage-collector-when-moving-from-java-8-to-java-11-71e60f9b81f
 * TODO: Note - tuning the GC may be of great importance... (how do these issues look like in C# ?)
 */
public class GCDemoTest {

    public static void main(String[] args) {
//        Vector<Dog> vector = new Vector<>();

        Dog bobick = new Dog("Bobick", 1);
        Dog juchka = new Dog("Juchka", 2);

        System.out.println(bobick);
        System.out.println(juchka);

//        vector.add(bobick);
//        vector.add(juchka);

        bobick = null;
        System.out.println("Calling runFinalization() #1...");
        System.runFinalization();
        System.out.println("Calling gc() #1...");
        System.gc();

//        vector = null;

        System.out.println("Calling runFinalization() #2...");
        System.runFinalization();
        System.out.println("Calling gc() #2...");
        System.gc();

        juchka = null;
        System.out.println("Calling runFinalization() #3...");
        System.runFinalization();
        System.out.println("Calling gc() #3...");
        System.gc();
        System.out.println("End of main...");
    }
}
