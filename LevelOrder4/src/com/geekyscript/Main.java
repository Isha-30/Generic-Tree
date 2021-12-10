package com.geekyscript;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i = 0; i<arr.length; i++) {
            if (arr[i] == -1) st.pop();
            else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() > 0) st.peek().children.add(t);
                else root = t;
                st.push(t);
            }
        }
        levelOrder4(root);
    }

    public static void levelOrder4(Node node){
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(node, 1));

        int level = 1;
        while(mq.size()>0){
            Pair p = mq.remove();
            if(p.level > level) {
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for(Node child : p.node.children){
                Pair cp = new Pair(child, p.level+1);
                mq.add(cp);
            }
        }

    }
}
