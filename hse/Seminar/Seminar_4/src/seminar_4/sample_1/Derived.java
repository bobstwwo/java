package seminar_4.sample_1;

// Why IDEA shows that this class is runnable (i.e. it has a main-method) wile the main-method is not written here?
// Why we see @Override compile error when Base.f() - method is declared private (and no error otherwise)?
// What will be printed when starting this class to run? Why?

public class Derived extends Base {
    public Derived() {
        this.f(); // how does that matter ?
//        super(); // how does that matter ?
//        super.f(); // how does that matter ?
    }

    @Override
    public void f() {
        print(" derived f()");
    }
}
