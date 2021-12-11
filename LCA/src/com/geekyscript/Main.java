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
        System.out.println(lca(root, 110, 70));
    }

    public static int lca(Node node, int d1,int d2){
        ArrayList<Integer> p1 = Path(node, d1);
        ArrayList<Integer> p2 = Path(node, d2);

        int i = p1.size()-1;
        int j = p2.size()-1;

        while(i>=0 && j>=0 && p1.get(i)==p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return p1.get(i);
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
