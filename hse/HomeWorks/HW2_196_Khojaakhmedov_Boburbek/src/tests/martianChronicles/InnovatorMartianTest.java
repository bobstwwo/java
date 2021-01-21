package martianChronicles;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InnovatorMartianTest {
    private static InnovatorMartian<String> innovatorMartian;

    @BeforeAll
    static void BeforeAll() {
        innovatorMartian = new InnovatorMartian<>("Zoya");
        var par = new InnovatorMartian<>("Parent");
        innovatorMartian.parent = par;
        innovatorMartian.collOfChild.add(new InnovatorMartian<>("Mila"));
        innovatorMartian.collOfChild.add(new InnovatorMartian<>("Zika"));
        innovatorMartian.collOfChild.add(new InnovatorMartian<>("Lea"));
    }

    @AfterAll
    static void AfterAll() {
        innovatorMartian = null;
    }

    @Test
    void gainCollOfDes() {
        var rez = innovatorMartian.collOfChild;
        assertEquals(rez,innovatorMartian.gainCollOfDes(innovatorMartian));
    }

    @Test
    void setGenCode() {
        assertEquals(true, innovatorMartian.setGenCode("Nika"));
    }

    @Test
    void setParent() {
        InnovatorMartian parent = new InnovatorMartian<>("Burger");
        try {
            assertEquals(true, innovatorMartian.setParent(parent));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void setCollOfDes() {
        ArrayList<InnovatorMartian<String>> newArr = new ArrayList<>();
        newArr.add(new InnovatorMartian("Like"));
        newArr.add(new InnovatorMartian("Bella"));
        newArr.add(new InnovatorMartian("Sarka"));
    }

    @Test
    void setChild() {
        var child = new InnovatorMartian<>("Mariya");
        assertEquals(true, innovatorMartian.setChild(child));
    }

    @Test
    void remChild() {
        var child = innovatorMartian.collOfChild.get(0);
        assertEquals(true, innovatorMartian.remChild(child));
    }

    @Test
    void hasDescendantWithValue() {
        assertEquals(false, innovatorMartian.hasChildWithValue(innovatorMartian.value));
    }

    @Test
    void hasChildWithValue() {
        assertEquals(true, innovatorMartian.hasChildWithValue("Mila"));
    }

    @Test
    void getCollOfDes() {
        var rez = innovatorMartian.collOfChild;
        assertEquals(rez.size(), innovatorMartian.gainCollOfDes(innovatorMartian).size());
    }

    @Test
    void getCollOfChild() {
        int v = innovatorMartian.collOfChild.size();
        assertEquals(v, innovatorMartian.getCollOfChild().size());
    }

    @Test
    void getParent() {
        innovatorMartian.parent = null;
        assertEquals(null, innovatorMartian.getParent());
    }
}