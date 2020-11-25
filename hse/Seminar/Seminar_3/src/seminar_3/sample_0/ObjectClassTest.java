package seminar_3.sample_0;

//import java.lang.*;

//TODO: walk step by step in debugger...(explain - what's happening...)


public class ObjectClassTest {
    public static void main(String[] args) {
        Object o1 = new Object();
System.out.println("o1 = " + o1);
//TODO: explain warnings and "raw" type usage: 1) generic types will be discussed later, 2) just Class<?> is ok for now
        Class c1 = o1.getClass();
System.out.println("c1 = " + c1);
        Object o2 = c1;
System.out.println("o2 = " + o2);
        Class c2 = o2.getClass();
System.out.println("c2 = " + c2);
        Object o3 = c2;
System.out.println("o2 = " + o2);
        Class c3 = o3.getClass();
System.out.println("c3 = " + c3);

    }
}
