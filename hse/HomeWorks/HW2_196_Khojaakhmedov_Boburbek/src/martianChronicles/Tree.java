package martianChronicles;

import java.util.ArrayList;

public class Tree {
    ArrayList<Martian> graph;
    ArrayList<Martian> used;

    public Tree(Martian head){
        graph = head.getCollOfChild();
        used = new ArrayList<>();
    }

    //    public void print(Martian root) {
//        ArrayList<Martian> graph = root.getCollOfChild();
//        System.out.println(root);
//
//
//    }

    public void dfs(Martian pos) {
        used.add(pos);
        System.out.println(pos);
        for (Martian next : graph){
            if (!used.contains(next)){
                dfs(next);
            }
        }
    }
}
