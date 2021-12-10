package com.geekyscript;

import java.util.*;

public class Main {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
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
        mirror(root);
        levelOrder3(root);
    }

    public static void mirror(Node node){
        for(Node child : node.children)
            mirror(child);
        Collections.reverse(node.children);
    }
    public static void levelOrder3(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while(mq.size()>0){
            int cs = mq.size();
            for(int i = 0; i<cs; i++){
                node = mq.remove();
                System.out.print(node.data+" ");

                for(Node child : node.children){
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }
}
