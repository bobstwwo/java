package seminar_4.sample_1;

/**
 * TODO: uncomment (one by one) access specifiers at f() and explain the difference for private...
 * What will be printed when starting this class to run? Why?
 * What we have to do in order to see " base f()" printed?
 */
public
class Base {
    // Print with a newline:
    static void print(Object obj) {
        System.out.println(obj.toString());
    }

    Base() {
        this.f();
    }

//  public
//  protected
//  private
    void f() {
        print(" base f()");
    }

    public static void main(String[] args) {
        Base po = new Derived();
//        Base po = new Base();
        po.f();
    }
}

//TODO: comparing with the following (commented out) Derived class:
// is there any difference with the Derived class declared in its' own compilation unit?
// For example - with the one declared in a different package?
/*
class Derived extends Base {
//    @Override
    public void f() {
        print(" derived f()");
    }
}
//*/
