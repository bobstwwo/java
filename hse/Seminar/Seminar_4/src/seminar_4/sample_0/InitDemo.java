package seminar_4.sample_0;

//TODO: the program to illustrate class and instance initializations with an inheritance presence...
//TODO: explain - what is going on - step by step...
//TODO: try to simplify the following program with more code reuse...


class A {
    static {
        System.out.println("A: static initializer invoked. Counter = " + MyCounter.getValue() );
    }

    private final int counter;

    A(){
        this.counter = MyCounter.getValue();
        System.out.println("A: constructor invoked. Counter = " + getCounter());
    }

    private int getCounter() {
        return counter;
    }

}

class B extends A {
    static {
        System.out.println("B: static initializer invoked. Counter = " + MyCounter.getValue());
    }

    private final int counter;

    B() {
        this.counter = MyCounter.getValue();
        System.out.println("B: constructor invoked. Counter = " + getCounter());
    }
    private int getCounter() {
        return counter;
    }
}

class C extends B {
    static {
        System.out.println("C: static initializer invoked. Counter = " + MyCounter.getValue());
    }

    private final int counter;

    C() {
        this.counter = MyCounter.getValue();
        System.out.println("B: constructor invoked. Counter = " + getCounter());
    }
    private int getCounter() {
        return counter;
    }
}

public class InitDemo extends C {
    static {
        System.out.println("InitDemo: static initializer invoked. Counter = " + MyCounter.getValue());
    }

    private final int counter;

    public InitDemo(){
        this.counter = MyCounter.getValue();
        System.out.println(getClass().getSimpleName() + " constructor invoked. Counter = " + getCounter());
    }

    private int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        Object o = new InitDemo();
        System.out.println("o = " + o);
    }
}

class MyCounter {
    private static int VALUE = 0;

    static {
        System.out.println("MyCounter: static initializer invoked. Counter = " + getValue());
    }

    static int getValue() { return VALUE++; }
}