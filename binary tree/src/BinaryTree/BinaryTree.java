package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
    private Node root;
    int n;


    private Node addRecursive(Node current, int value) {
        if (current == null) {
            current = new Node(value);
            System.out.println("Element " + value +" added.");
            return current;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            if (node == null) {
                node = new Node(value);
                System.out.println("Element " + value +" added.");
            }
            int i =0;

            if (node.left != null) {
                if(node.right == null){
                    node.right = new Node(value);
                    System.out.println("Element " + value +" added.");
                    return current;
                }
                nodes.add(node.left);
            }
            else if(node.left == null){
                node.left = new Node(value);
                System.out.println("Element " + value +" added.");
                return current;
            }
            if (node.right!= null) {
                nodes.add(node.right);
            }


        }


        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private void printLevel(Node current) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            int i =0;

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right!= null) {
                nodes.add(node.right);
            }
        }

    }
    public void print(){
        printLevel(root);
    }

    //Обратный
    private void traverseInOrder1(Node node, int data) {
        if (node != null) {
            if(node.value == data)
                n = data;
            traverseInOrder1(node.left, data);
            if(n!= data)
                System.out.print(" " + node.value);
            traverseInOrder1(node.right, data);
        }

    }
    public  void traverseInOrder(int data) {
        traverseInOrder1(root, data);
        System.out.print(" " + data);
        System.out.println();
        n = 0;
    }
    //Прямой
    private void traversePreOrder1(Node node,int data) {
        if (node != null) {
            if(node.value == data)
                n = data;
            if(n!= data)
                System.out.print(" " + node.value);
            traversePreOrder1(node.left, data);
            traversePreOrder1(node.right, data);
        }
    }
    public  void traversePreOrder( int data){
        traversePreOrder1(root, data);
        System.out.print(" " + data);
        System.out.println();
        n = 0;
    }

    private void inorderTraversal( Node x) {
        if (x != null) {
            inorderTraversal(x.left);
            System.out.println(x.value);
            inorderTraversal(x.right);
        }
    }
    public void inorderTraversal1() {
        inorderTraversal(root);
    }

    public void preorderTraversal( Node x) {
        if (x != null) {
            System.out.println(x.value);
            preorderTraversal(x.left);
            preorderTraversal(x.right);
        }
    }
}
