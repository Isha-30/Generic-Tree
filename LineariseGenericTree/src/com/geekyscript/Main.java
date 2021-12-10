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

    public static void main(String[] args) {
        // write your code here
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
        linearise(root);
        levelOrder3(root);
    }
    public static void linearise(Node node){
        for(Node child : node.children){
            linearise(child);
        }
        while(node.children.size()>1){
            Node last = node.children.remove(node.children.size()-1);
            Node secondLast = node.children.get(node.children.size()-1);
            Node tail = getTail(secondLast);
            tail.children.add(last);

        }
    }
    private static Node getTail(Node node){
        while(node.children.size()==1)
            node = node.children.get(0);
        return node;
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
