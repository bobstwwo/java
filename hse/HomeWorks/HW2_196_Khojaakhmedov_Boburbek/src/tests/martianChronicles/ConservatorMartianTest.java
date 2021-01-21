package martianChronicles;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class ConservatorMartianTest {
    private static ConservatorMartian conservatorMartian;
    private static ConservatorMartian parent;

    @BeforeAll
    static void BeforeAll()
    {
        ArrayList<ConservatorMartian> children = new ArrayList<>();
        children.add(new ConservatorMartian(null,"Lexi",null));
        children.add(new ConservatorMartian(null,"Aleksey",null));
        parent = new ConservatorMartian<>(null,"Parent",null);
        conservatorMartian = new ConservatorMartian(parent,"Marina",children);

    }
    @AfterAll
    static void AfterAll()
    {
        conservatorMartian = null;
        parent = null;
    }

    @Test
    void gainCollOfDes() {
    }


    @Test
    void hasChildWithValue() {
        assertEquals(true, conservatorMartian.hasChildWithValue("Lexi"));
    }

    @Test
    void getCollOfDes() {

    }

    @Test
    void getCollOfChild() {
        var rez = conservatorMartian.collOfChild;
        assertEquals(rez,conservatorMartian.getCollOfChild());
    }

    @Test
    void getParent() {
        assertEquals(parent,conservatorMartian.parent);
    }
}