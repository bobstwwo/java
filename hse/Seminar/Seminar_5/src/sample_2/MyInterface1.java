package sample_2;

public interface MyInterface1 {

    static float my_float_PI_provider(){
        return calculate_float_PI();
    }

    // TODO: show - it's ok in JDK9(+):
    private static float calculate_float_PI(){
        return (float)Math.PI;
    }

    int method1();
    default int method2() { return 1; }
}
