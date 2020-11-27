package com.company;

import martianChronicles.InnovatorMartian;
import martianChronicles.Martian;
import martianChronicles.Tree;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        InnovatorMartian<String> john = new InnovatorMartian<String>(null, "John", new ArrayList<Martian<String>>());
        InnovatorMartian<String> james = new InnovatorMartian<String>(null, "james", new ArrayList<Martian<String>>());
        InnovatorMartian<String> johan = new InnovatorMartian<String>(null, "johan", new ArrayList<Martian<String>>());
        InnovatorMartian<String> jamil = new InnovatorMartian<String>(null, "jamil", new ArrayList<Martian<String>>());
        InnovatorMartian<String> jared = new InnovatorMartian<String>(null, "jared", new ArrayList<Martian<String>>());
        james.setChild(jared);
        john.setChild(james);
        john.setChild(johan);
        InnovatorMartian<String> joel = new InnovatorMartian<String>(null, "joel", new ArrayList<Martian<String>>());
        InnovatorMartian<String> jack = new InnovatorMartian<String>(null, "jack", new ArrayList<Martian<String>>());
        joel.setChild(jack);
        jamil.setChild(joel);
        john.setChild(jamil);
        Tree tr = new Tree();
        String rez = tr.dfs(john, 0);
        System.out.print(rez);
        Martian mr = tr.getTree(rez);
        String rez2 = tr.dfs(mr, 0);
        System.out.print(rez2);
//        ArrayList<InnovatorMartian> list = ((InnovatorMartian) mr).getCollOfChild();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).value);
//        }
    }
}
