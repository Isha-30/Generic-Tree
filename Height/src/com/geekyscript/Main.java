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
        System.out.println(height(root));
    }

    public static int height(Node node){
        int h = -1;
        for(Node child : node.children){
            int ch = height(child);
            h = Math.max(ch, h);
        }
        return h+1;
    }
}
