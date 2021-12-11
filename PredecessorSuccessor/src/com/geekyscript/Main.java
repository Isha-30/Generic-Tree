package com.geekyscript;

import java.util.ArrayList;
import java.util.Stack;

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
        predecessorSuccessor(root, 110);
        System.out.println("Predecessor = "+predecessor.data);
        System.out.println("Successor = "+successor.data);
    }

    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorSuccessor(Node node, int data){
        if(state==0){
            if(node.data == data){
                state = 1;
            }
            else{
                predecessor = node;
            }
        }
        else if(state == 1){
            successor= node;
            state=2;
        }
        for(Node child : node.children)
            predecessorSuccessor(child,data);
    }
}
