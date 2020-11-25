package seminar_3.sample_4;

//TODO: class naming demo: highlight array classes naming rules (see below)...
//TODO: simple names vs. canonical names vs. names (used in Class.forName()-method)...

public class ClassNamesDemo {
    public static void main(String[] args) {
        System.out.println("class.getSimpleName() = " + ClassNamesDemo.class.getSimpleName()); // class literal usage...
        System.out.println("class.getCanonicalName() = " + ClassNamesDemo.class.getCanonicalName());
//        System.out.println("class.getName() = " + new ClassNamesDemo().getClass().getName());
        System.out.println("class.getName() = " + ClassNamesDemo.class.getName());

        //and what about arrays? Don't ask me - why...
        SomeClass[] someArray = new SomeClass[0];
        System.out.println("someArrayClass.getSimpleName() = " + someArray.getClass().getSimpleName());
        System.out.println("someArrayClass.getCanonicalName() = " + someArray.getClass().getCanonicalName());
        System.out.println("someArrayClass.getName() = " + someArray.getClass().getName());

        System.out.println();

        System.out.println("void.class = " + void.class.getName());
        System.out.println("boolean.class = " + boolean.class.getName());
        System.out.println("byte.class = " + byte.class.getName());
        System.out.println("char.class = " + char.class.getName());
        System.out.println("short.class = " + short.class.getName());
        System.out.println("int.class = " + int.class.getName());
        System.out.println("long.class = " + long.class.getName());
        System.out.println("float.class = " + float.class.getName());
        System.out.println("double.class = " + double.class.getName());

        System.out.println();

//        System.out.println("void[].class = " + void[].class.getName());
        System.out.println("boolean[].class = " + boolean[].class.getName());
        System.out.println("byte[].class = " + byte[].class.getName());
        System.out.println("char[].class = " + char[].class.getName());
        System.out.println("short[].class = " + short[].class.getName());
        System.out.println("int[].class = " + int[].class.getName());
        System.out.println("long[].class = " + long[].class.getName());
        System.out.println("float[].class = " + float[].class.getName());
        System.out.println("double[].class = " + double[].class.getName());

        System.out.println();

        System.out.println("boolean[][].class = " + boolean[][].class.getName());
        System.out.println("byte[][].class = " + byte[][].class.getName());
        System.out.println("char[][].class = " + char[][].class.getName());
        System.out.println("short[][].class = " + short[][].class.getName());
        System.out.println("int[][].class = " + int[][].class.getName());
        System.out.println("long[][].class = " + long[][].class.getName());
        System.out.println("float[][].class = " + float[][].class.getName());
        System.out.println("double[][].class = " + double[][].class.getName());

        System.out.println();

        System.out.println("String[].class = " + String[].class.getName());
        System.out.println("String[][].class = " + String[][].class.getName());

        System.out.println();

        // 1.
        Class c = null;
        try {
            c = Class.forName("java.lang.String");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("1: got exception: " + cnfe);
        }
        if (c != null)
            System.out.println("1: c.getName() = " + c.getName());

        // 2.
        try {
            String name = "java.lang.String[]";
            c = Class.forName(name);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("2: got exception: " + cnfe);
        }
        if (c != null)
            System.out.println("2: java.lang.String[].getName() = " + String[].class.getName());

        // 3.
        try {
            c = Class.forName("[Ljava.lang.String;");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("3: got exception: " + cnfe);
        }
        if (c != null)
            System.out.println("3: java.lang.String[].getName() = " + String[].class.getName());
    }
}

class SomeClass {}