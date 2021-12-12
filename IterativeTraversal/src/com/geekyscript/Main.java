package com.geekyscript;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};
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
        iterativeTraversal(root);
    }
    public static void iterativeTraversal(Node node){
        Stack<Pair> st = new Stack<>();
        st.push((new Pair(node, -1)));
        String pre = "";
        String post = "";
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==-1){
                pre += top.node.data + " ";
                top.state++;
            } else if (top.state == top.node.children.size()){
                post += top.node.data + " ";
                st.pop();
            } else{
                Pair cp = new Pair(top.node.children.get(top.state), -1);
                st.push(cp);
                top.state++;
            }
        }
        System.out.println("Preorder -> "+pre);
        System.out.println("Postorder -> "+post);
    }
}
