package seminar_3.sample_5;

//TODO: show the order of static and instance initializer execution...(step by step - using F7)

public class InitializationTest {

    static int INT_1  = 5;
    static int INT_2;

    static {
        System.out.println(INT_1);
        INT_2 = 7;
    }

    static int INT_3 = 9;

    static {
        System.out.println(INT_3);
    }

    int i1 = 1;
    int i2;

    {
        System.out.println(
                "i1 = "+ this.i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
                        + "i3 = "+ this.i3 + "\r\n"
                        + "i4 = "+ this.i4 + "\r\n"
        );
        i2 = 2;
        i3 = 3;
        i4 = -4;
        System.out.println(
                "i1 = "+ i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
//               + "i3 = "+ i3 + "\r\n"
//               + "i4 = "+ i4 + "\r\n"
                        + "i3 = "+ this.i3 + "\r\n"
                        + "i4 = "+ this.i4 + "\r\n"
        ); // NOTE: we can assign i3 = 3, but cannot read i3 without "this" here...
        i4 = 0;
    }

    int i3;
    int i4 = 4;

    {
        System.out.println(
                "i1 = "+ i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
                        + "i3 = "+ i3 + "\r\n"
                        + "i4 = "+ i4 + "\r\n"
        );
    }

    InitializationTest(){
        System.out.println(
                "i1 = "+ i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
                        + "i3 = "+ i3 + "\r\n"
                        + "i4 = "+ i4 + "\r\n"
        );
        i1 = i2 = i3 = i4 = 7;
        System.out.println(
                "i1 = "+ i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
                        + "i3 = "+ i3 + "\r\n"
                        + "i4 = "+ i4 + "\r\n"
        );
    }

    {
        System.out.println(
                "i1 = "+ i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
                        + "i3 = "+ i3 + "\r\n"
                        + "i4 = "+ i4 + "\r\n"
        );
        i1 = i2 = i3 = i4 = 5;
        System.out.println(
                "i1 = "+ i1 + "\r\n"
                        + "i2 = "+ i2 + "\r\n"
                        + "i3 = "+ i3 + "\r\n"
                        + "i4 = "+ i4 + "\r\n"
        );
    }

    public static void main(String[] args){
        Object t = new InitializationTest();
    }
}
