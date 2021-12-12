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
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height= 0;
        multisolver(root, 0);
        System.out.println("Size = " + size);
        System.out.println("Max value = " + max);
        System.out.println("Min value = " + min);
        System.out.println("Height = " + height);

    }
    static int size;
    static int height;
    static int max;
    static int min;
    public static void multisolver(Node node, int depth){
        size++;
        max = Math.max(node.data, max);
        min = Math.min(node.data, min);
        height = Math.max(depth, height);
        for(Node child : node.children)
            multisolver(child, depth+1);
    }

}
