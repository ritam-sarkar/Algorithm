package com.gs.easy;

import java.util.ArrayList;
import java.util.List;

public class BSTDemo {
    public static void main(String[] args) {

        BST bst = new BST();
        bst.put(5);
        bst.put(3);
        bst.put(7);
        bst.put(2);
        bst.put(4);
        bst.put(6);
        bst.put(10);
        bst.put(1);
        bst.put(11);
        bst.put(8);
        System.out.println(bst.root);
        System.out.println("contains 10 "+bst.contains(10));
        System.out.println("contains 5 "+bst.contains(5));
        System.out.println("contains 3 "+bst.contains(3));
        System.out.println("contains 12 "+bst.contains(12));
        bst.inOrderTraverse().stream().forEach(System.out::println);
        System.out.println(bst);
    }
    static class BST {
        private List<Integer> traverse = new ArrayList<>();
        private Node root;
        private static class Node {
            int value;
            Node left, right;

            Node(int value) {
                this.value = value;
            }
        }
        void put(int x){
            root = put(root,x);
        }
        Node put(Node node , int x){
           if(node == null){
               return new Node(x);
           } else {
               if(x <= node.value){
                   node.left = put(node.left,x);
               } else {
                   node.right = put(node.right,x);
               }
           }
           return node;
        }
        boolean contains(int x){
            Node node = root;
            return contains(node,x);
        }

        private boolean contains(Node node , int x){
            if(node == null){
                return false;
            } else {
                if(node.value == x){
                    return true;
                } else if(x <= node.value){
                    return contains(node.left,x);
                } else {
                    return contains(node.right, x);
                }
            }
        }

        List<Integer> inOrderTraverse(){
            inOrderTraverse(root);
            List<Integer> result =  new ArrayList<>(traverse);
            traverse.clear();
            return result;
        }
        private void inOrderTraverse(Node node){
            if(node != null) {
                inOrderTraverse(node.left);
                traverse.add(node.value);
                inOrderTraverse(node.right);
            }
        }

    }
}

