package sample_2;

import java.util.Random;

public class MyImplementor implements MyInterface1, MyInterface2, MyInterface3 {

    public static void main(String[] args) {
        MyImplementor myImplementor = new MyImplementor();
        System.out.println("result from method1(): " + myImplementor.method1());
        System.out.println("result from method2(): " + myImplementor.method2());
        System.out.println(myImplementor.myBehavior1());
        System.out.println(myImplementor.myBehavior2());
        System.out.println(myImplementor.circleLength(new Random().nextDouble()));
    }

    public int method1() { return 0; }

    // TODO: comment it out and see the compile error, that means something like "Don't know what to do..."
    // TODO: note that implementation in class overrides default-implementations in training.interfaces...
    @Override
    public int method2() {
        return 0;
    }

    private int myBehavior1() {
        int v = MyInterface1.super.method2();
        System.out.println("v = " + v);
        return v;
    }

    private int myBehavior2() {
//        int v = MyInterface2.super.method2(); //TODO: explain - why here is compile error?
        int v = MyInterface3.super.method2(); //TODO: explain - why that's ok (in contrast...)
        System.out.println("v = " + v);
        return v;
    }

    private double circleLength(double radius) {
        return MyInterface1.my_float_PI_provider() * radius * 2;
    }
}
