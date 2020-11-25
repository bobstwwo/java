package seminar_3.sample_9;

/**
 *
 */
public class MiscellaneousSamples {

    private final float[] FLOAT_ARRAY_1 = new float[0];
    private final float[] FLOAT_ARRAY_2 = new float[] {1, 2, 3};
    private static final String S_1 = "abcdefg";

    private MiscellaneousSamples(){
    }

    public static void main(String[] args){
        MiscellaneousSamples myObject = new MiscellaneousSamples();
        System.out.println("myObject: " + myObject.toString());

        //todo: show that class of myObject is MiscellaneousSamples.class
        System.out.println("myObject.getClass() = " + myObject.getClass());

        //todo: what is the class of FLOAT_ARRAY_1?  and FLOAT_ARRAY_2 ?...show class of them...
        System.out.println("FLOAT_ARRAY_1.getClass() = " + myObject.FLOAT_ARRAY_1.getClass());
        System.out.println("FLOAT_ARRAY_2.getClass() = " + myObject.FLOAT_ARRAY_2.getClass());

//        int a =  (- 1 -);
        int b =  (+ + 1);
        int c =  (+-+-+-1);
//        int d = (--1);
//        int e =  (1 * * 1);
        int f =  (- -1);

        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("f = " + f);

        //TODO: explain <String>.intern() - method usage...
        String myString1 = S_1;
        String myString2 = "abcdefg";
        String myString3 = new String("abcdefg");
        String myString4 = myString3.intern();

        System.out.println("(myString1 == myString2)? -> " + (myString1 == myString2));
        System.out.println("(myString1 == myString3)? -> " + (myString1 == myString3));
        System.out.println("(myString2 == myString3)? -> " + (myString2 == myString3));
        System.out.println("(myString1 == myString4)? -> " + (myString1 == myString4));
    }
}
