package martianChronicles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTest {

    @Test
    void dfs() {
        String result = "InnovatorMartian (String:John)\n" +
                "    InnovatorMartian (String:james)\n" +
                "        InnovatorMartian (String:jared)\n" +
                "    InnovatorMartian (String:johan)\n" +
                "    InnovatorMartian (String:jamil)\n" +
                "        InnovatorMartian (String:joel)\n" +
                "            InnovatorMartian (String:jack)";

        InnovatorMartian<String> john = new InnovatorMartian<String>("John");
        InnovatorMartian<String> james = new InnovatorMartian<String>("james");
        InnovatorMartian<String> johan = new InnovatorMartian<String>("johan");
        InnovatorMartian<String> jamil = new InnovatorMartian<String>("jamil");
        InnovatorMartian<String> jared = new InnovatorMartian<String>("jared");
        james.setChild(jared);
        john.setChild(james);
        john.setChild(johan);
        InnovatorMartian<String> joel = new InnovatorMartian<String>("joel");
        InnovatorMartian<String> jack = new InnovatorMartian<String>("jack");
        joel.setChild(jack);
        jamil.setChild(joel);
        john.setChild(jamil);
        Tree tr = new Tree();
        String rez = tr.dfs(john, 0);
        System.out.println(rez);
    }

}