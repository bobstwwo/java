package seminar_3.sample_2.package_1;

//TODO: we cannot call a public method from non-public class of another package...

//public // TODO: note - but we can invoke public static void main from non-public class... (from command line, i.e. from OS)
class UserClass {
    public static void main(String[] args) {
        Object o = new seminar_3.sample_2.package_2.SomeClass();
    }
}

