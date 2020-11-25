package seminar_4.sample_6;

class A {
    void f() {
        System.out.println("A.f()");
    }
}

class B extends A {
    void f() {
        System.out.println("B.f()");
    }
}

class C extends B {
    void f() {
        System.out.println("C.f()");
    }
}

// TODO: go step by step in Debugger and explain everything that's going on...
//  what is called/printed and why...

class Test {
    public static void main(String[] args) {
        // 1:
        A a = new A();
        a.f();

        // 2:
        a = new B();
        a.f();

        // 3:
        a = new C();
        a.f();

        // 4:
//        B b = new A(); //TODO: why it is wrong?
        B b = new B();
        a = b;
        a.f();

        // 5:
        C c = new C();
        a = c;
        a.f();

        // 6:
        b = c;
        a = b;
        a.f();

        // 7;
        a = (A) c;
        a.f();
    }
}