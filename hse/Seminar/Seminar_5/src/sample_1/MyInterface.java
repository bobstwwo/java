package sample_1;

//This sample illustrates methods in interface usage, their accessibility and initialization order when running...

//TODO: execute main()-method step by step (F7): see what's going on and when...
//TODO: uncomment commented strings and explain the difference...

interface MyInterface {

    public static final int VALUE = 7; // TODO: note - public static final is redundant...

//    static {  } //TODO - static initializers are not allowed in interface

    //TODO: note that public is redundant below:
    public static int initNumber() {
        System.out.println("initNumber() invoked.");
        return helper();
    }

    //TODO: note -  private static method helps to implement public static methods (using subprograms)...
    private static int helper() {
        return VALUE;
    }

    int INT_NUMBER = initNumber();

    // TODO: note that public is redundant here...
    public default int getIntNumber() {
        return intGetter();
    }

    //    private //TODO: uncomment & explain...(private method cannot be default...)
//    static  //TODO: uncomment & explain...(static method cannot be default...)
    default int intGetter() {
        return calculate();
    }

    //TODO: note - private non-static methods help to implement default-methods in interface (using subprograms)...
    private int calculate() {
        return INT_NUMBER;
    }
    //TODO: now we can have main()-method in interface...
    public static void main(String[] args) {
        System.out.println("MyInterface.INT_NUMBER = " + MyInterface.INT_NUMBER);
    }
}

class MyObject implements MyInterface {
    static {
        System.out.println("MyObject: static initializer");
    }

    public static void main(String[] args) {
        System.out.println("MyInterface.INT_NUMBER = " + MyInterface.INT_NUMBER);
    }
}