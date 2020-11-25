package seminar_4.sample_5;

// TODO: explain the following:
//  http://www.fredosaurus.com/notes-java/oop/constructors/constructor-super-example.html

class Parent {
    private final int x;
    Parent(int x) {
        this.x = x;
    }

//    public int getX() {
//        return x;
//    }
}

class Child extends Parent {
    private final int y;
    Child (int y) {
        super(0);
        this.y = y;
    }
//    Child (int x, int y) {
//        super(x);
//        this.y = y;
//    }

//    public int getY() {
//        return y;
//    }

}

public class ParentChild {
    public static void main(String[] args) {
        new Child(3);
//        new Child(1, 2);
    }
}
