package seminar_3.sample_10;

/**
 */
public class Dog {

    //TODO:  what should or should not be final ? Why ?
    private final String name;
    private final int age;

    //TODO: why there is no default-constructor ? What default-constructor could mean here ?
    //public
    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = " + name + "; age = " + age;
    }

    //TODO: what accessors and/or mutators could be relevant here ? Why ?

    // TODO: note "public" instead of "protected" in Object.finalize()
    // TODO: note we do not throw exception...
    // TODO: note a warning, if we do not call super.finalize()...
    public void finalize() throws Throwable {
        super.finalize();
//        System.out.println(name + " is being garbage collected");
        System.out.println("thread: " + Thread.currentThread() + ": " + name + " is being garbage collected");
    }
}
