package sample_3;

/**
 * TODO: answer - what should be printed and why ? Explain - what's happening...
 */

class A {
   A() {
      System.out.println("this.getClass() : "  + this.getClass());
      init();
   }
   public void init() {
   }
}

class B extends A {

   private final Integer i = 1;                 //Integer.valueOf(1); // at init() is not initialized  yet...
   private final int ii = 320000;               // (as statically known by compiler it is inlined in methods...!!!)
   private int iii = 3;                         // at init() is not initialized yet...

   B() {
      super();
   }

   // TODO: look at the console output:
   public void init() {
      System.out.println(" i = " + i);
      System.out.println(" ii = " + ii); // TODO: why it is initialized when i and iii are not initialized ?
      System.out.println(" iii = " + iii);
   }

   Integer getI() {
      return i;
   }
   int getIi() {
      return ii;
   }
   int getIii(){
      return iii;
   }
}

public class InitTest {
   // TODO: stop at the very first line and execute step by step... (or just run and ask to explain the output...)
   public static void main(String[] args){
      B b = new B();
      System.out.println(" i = " + b.getI());
      System.out.println(" ii = " + b.getIi());
      System.out.println(" iii = " + b.getIii());
   }
}
