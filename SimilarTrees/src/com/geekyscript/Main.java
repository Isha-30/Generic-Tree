package com.geekyscript;

import java.lang.reflect.Array;
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
        int[] arr2 = {100, 200, 500, -1, 600, -1, -1, 300, 700, -1, 800, 1100, -1, 1200, -1, -1, 900, -1, -1, 400, 1000, -1, -1, -1};
        Node root2 = null;
        Stack<Node> st2 = new Stack<>();
        for(int i = 0; i<arr2.length; i++) {
            if (arr2[i] == -1) st2.pop();
            else {
                Node t = new Node();
                t.data = arr2[i];
                if (st2.size() > 0) st2.peek().children.add(t);
                else root2 = t;
                st2.push(t);
            }
        }
        System.out.println("Are the trees Similar:" + areSimilar(root, root2));
    }

    public static boolean areSimilar(Node n1, Node n2){
        if(n1.children.size()!=n2.children.size()) return false;
        for(int i = 0; i<n1.children.size(); i++){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if(!areSimilar(c1, c2)) return false;
        }
        return true;
    }
}
