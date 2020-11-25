package sample_2;

public interface MyInterface2 {
    int method1();
    default int method2() { return 2; }
}
