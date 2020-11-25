package sample_4;

public class OuterClass {

    public static final Object INNER_OBJECT = new Object();
    private static final int STATIC_FINAL_INT = 2;

    //TODO: show warning (... may be static) and explain it...
    private class InnerClass {
//        public static final Object INNER_OBJECT = new Object();   // compile error! why?
//        public static int STATIC_INT = 2;                         // compile error! why?
        public static final int STATIC_FINAL_INT = 3; //todo: explain - why it's ok (instead of attempts above)?

        private int getInnerStaticFinalIntValue(){
            return STATIC_FINAL_INT;
        }

        //TODO: note that IDEA compiler shows warnings when Oracle compiler does not...
        private int getOuterStaticFinalIntValue(){
            //TODO: explain warning below: access to static field by instance reference:
            return OuterClass.this.STATIC_FINAL_INT;
            // TODO: comment out rows written above and below, and explain warning that will be shown at the InnerClass...
//            System.out.println(OuterClass.this);
            //TODO: uncomment below when commenting out all above written lines of the method:
//            return OuterClass.STATIC_FINAL_INT; // access to static field by class reference
        }
    }

    InnerClass getInnerInstance(OuterClass o){
        InnerClass res = o.new InnerClass();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        InnerClass innerInstance = new OuterClass().new InnerClass();
        System.out.println("value = " + innerInstance.getInnerStaticFinalIntValue());
        System.out.println("value = " + innerInstance.getOuterStaticFinalIntValue());
    }
}

class A{
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        Object obj = outerClass.getInnerInstance(outerClass);
        System.out.println(obj);
    }
}