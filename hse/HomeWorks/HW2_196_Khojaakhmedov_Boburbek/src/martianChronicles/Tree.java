package martianChronicles;

import java.util.ArrayList;
import java.util.Collections;


public class Tree {
    ArrayList<Martian> graph;
    ArrayList<Martian> used;
    ArrayList<Martian> allMart = new ArrayList<>();

    public Tree() {
        used = new ArrayList<>();
    }

    public String dfs(Martian pos, int space) {
        String result = "";
        graph = pos.getCollOfChild();
        if (pos instanceof InnovatorMartian) {
            used.add(pos);
            for (int i = 0; i < space; i++) {
                result += "    ";
            }
            result += "InnovatorMartian (" + ((InnovatorMartian) pos).value.getClass().getSimpleName() + ":" + ((InnovatorMartian) pos).value + ")\n";
            for (Martian next : graph) {
                if (!used.contains(next)) {
                    result += dfs(next, space + 1);
                }
            }
        }
        return result;
    }

    public Martian getTree(String record) {
        String lines[] = record.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] head = lines[i].split("\\(|\\)|:");
            addMartian(head);
        }
        relocateChild();
        return allMart.get(0);
    }

    private Martian getMartian(String[] head) {
        if (head[0].equals("InnovatorMartian")) {
            if (head[1].equals("Integer")) {
                return new InnovatorMartian(null, Integer.parseInt(head[2]), null);
            }
            if (head[1].equals("Double")) {
                return new InnovatorMartian(null, Double.parseDouble(head[2]), null);
            }
            return new InnovatorMartian(null, head[2], null);
        } else {
            if (head[1].equals("Integer")) {
                return new ConservatorMartian(null, Integer.parseInt(head[2]), null);
            }
            if (head[1].equals("Double")) {
                return new ConservatorMartian(null, Double.parseDouble(head[2]), null);
            }
            return new ConservatorMartian(null, head[2], null);
        }
    }

    private char[] getArrChar(String str) {
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        return ch;
    }

    private void addMartian(String head[]) {
        int space = 0;
        String val = "";
        char[] first = getArrChar(head[0]);
        for (int i = 0; i < first.length; i++) {
            if (first[i] == ' ') {
                space += 1;
            } else {
                val += first[i];
            }
        }
        head[0] = val;

        Martian mr = getMartian(head);
        mr.shifts = space - 1;
        allMart.add(mr);
    }

    private void relocateChild() {
        int ch = allMart.get(allMart.size() - 1).shifts;
        Collections.reverse(allMart);
        for (int i = 0; i < allMart.size(); i++) {
            if (allMart.get(i).shifts == ch - 4) {
                ((InnovatorMartian) allMart.get(i)).collOfChild.add(allMart.get(i - 1));
                allMart.remove(allMart.get(i - 1));
                Collections.reverse(allMart);
                if (allMart.size() == 1) {
                    return;
                } else {
                    relocateChild();
                }
            }
        }
    }
}