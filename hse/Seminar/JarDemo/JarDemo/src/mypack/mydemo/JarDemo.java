package mypack.mydemo;

public class JarDemo {
    public static void main(String[] args) {
        System.out.println("Hello, World! (from JarDemo)");
        for (int i = 0; i < args.length; i++) {
            System.out.println("   args[" + i + "]: " + args[i]);
        }
    }
}
