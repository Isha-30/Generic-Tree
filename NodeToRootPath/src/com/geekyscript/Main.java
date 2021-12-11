package com.geekyscript;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Integer> ans = Path(root, 110);
        System.out.println("Path from Node to root " + ans);
        Collections.reverse(ans);
        System.out.println("Path from root to node " + ans);

    }

    public static ArrayList<Integer> Path(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for(Node child : node.children){
            ArrayList<Integer> path = Path(child, data);
            if(path.size()>0){
                path.add(node.data);
                return path;
            }
        }
        return new ArrayList<>();
    }
}
