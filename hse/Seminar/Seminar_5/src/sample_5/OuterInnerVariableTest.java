package sample_5;

//TODO: what will be printed and why?
//TODO: run as is, then try with line 16 commented out...what's up?
//TODO: again - note that IDEA compiler shows warnings while JDK-compiler does not...

class OuterClass {

    private int v = 7;
    private int w = 1;

    class InnerClass {
        InnerClass() {}

        //TODO: compare two cases - having the following line 1) uncommented, and 2) commented out:
        private int w = 2;

        void output1(){
            System.out.println("output1(): " + OuterClass.this.w);
            System.out.println("output1(): " + OuterClass.this.v);
        }
        void output2(){
            System.out.println("output2(): " + w); // variable is directly accessible from outer class instance
            System.out.println("output2(): " + v);
        }
        //TODO: explain the difference - this.w vs. w:
//        void output3(){
//            System.out.println("output3(): " + this.w); // this in inner class means exactly this...
//            System.out.println("output3(): " + w); // var in inner class means any var accessible from inner class instance
//            System.out.println("output3(): " + v);
//        }
    }
}

public class OuterInnerVariableTest {
    public static void main(String[] args) {
        OuterClass.InnerClass myInnerObject = new OuterClass().new InnerClass();
        //TODO: what need to be changed in order the following line to be uncommented and compiled without errors?
//        OuterClass.InnerClass myInnerObject = new OuterInnerVariableTest().new OuterClass().new InnerClass();
        myInnerObject.output1();
        myInnerObject.output2();
//        myInnerObject.output3();
    }
}
