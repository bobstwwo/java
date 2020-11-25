package sample_2;

public interface MyInterface3 extends MyInterface2 {

    default int method2() {
        return MyInterface2.super.method2(); // delegates to the parent interface...
    }

}
