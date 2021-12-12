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
        System.out.println(KthLargest(root, 3));
    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    public static void ceilFloor(Node node, int data){
        if(node.data>data){
            if(node.data<ceil)
                ceil = node.data;
        }
        if(node.data<data){
            if(node.data>floor)
                floor = node.data;
        }
        for(Node child : node.children)
            ceilFloor(child, data);
    }

    public static int KthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;

        for(int i = 0; i<k; i++){
            ceilFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }
}
