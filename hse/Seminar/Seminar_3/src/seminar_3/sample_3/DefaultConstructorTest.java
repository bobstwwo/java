package seminar_3.sample_3;

import java.lang.reflect.Constructor;
import java.util.Arrays;

//TODO: Note: when compiler has a class with no constructors, the default-constructor has the same access as its' class.
//TODO: we can use Java Bytecode Decompiler (e.g. Idea plugin) to see the constructor(s)...

public class DefaultConstructorTest {
    public static void main(String[] args) {
        Constructor[] constr_A = A.class.getDeclaredConstructors(); //Constructors();
        System.out.println("Constructors of A = " + Arrays.toString(constr_A));
        Constructor[] constr_B = B.class.getConstructors();
        System.out.println("Constructors of B = " + Arrays.toString(constr_B));
    }
}

//TODO: that is a sample of the two classes in one source file (and class A cannot be public... - why?)
//TODO: non-public class has non-public no-arguments constructor...
class A {
}