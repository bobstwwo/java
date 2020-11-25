package seminar_4.sample_4;

import seminar_4.sample_4.base.TestBaseClass;

/**
 * TODO: read code and explain - why we cannot uncomment lines marked with ???
 */
public class ProtectedTest extends TestBaseClass {

    public ProtectedTest() {
        createObject(); // ok
    }

    public static void main(String[] args) {

        TestBaseClass tb1 = new TestBaseClass();
//        tb1.createObject(); // compile error - ??? (we use a reference of our supertype type...)

        tb1 = new ProtectedTest();
//        tb1.createObject();  //??? (compiler does not execute a program; it sees a type of reference...)

        new ProtectedTest().createObject(); //ok (because compiler knows that the type of a called object is our own...)

        ProtectedTest tb2 = new ProtectedTest(); // (exactly like here - when we tell that explicitly...)
        tb2.createObject(); // ok

        TestBaseClass tb3 = new ProtectedTest();
//        tb3.createObject(); // ??? (same as for tb1...)
        var tb4 = new ProtectedTest();
        tb4.createObject(); // ok - why? (because it is the same as tb2... - type inferring by compiler in JDK10(+))
    }

    //TODO - think - how protected member of the base class is accessed by reference
    void someMethod() {
        createObject(); //ok
        this.createObject(); //ok
        super.createObject(); //ok

        TestBaseClass tbc = new ProtectedTest();
//        tbc.createObject();

        ProtectedTest pt = (ProtectedTest) tbc;
        pt.createObject(); //ok
    }
}
