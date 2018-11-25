package cn.kgeek.sunflower.components.form;

import java.util.LinkedList;
import java.util.List;

public class ChildrenNode {
    private List<ChildrenNode> childrenNode = new LinkedList<>();
    public static void main(String[] args) {
        ChildrenNode ch1 = new ChildrenNode();
        ChildrenNode ch2 = new ChildrenNode();

        System.out.println(ch1.childrenNode.equals(ch2.childrenNode));
    }
}
