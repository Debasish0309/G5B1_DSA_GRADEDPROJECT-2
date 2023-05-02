package com.glearning.question2;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Main {
    static Node node;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);
        
        System.out.println("Inorder traversal of original BST:");
        inorder(tree.node);
        
        Node skewedRoot = modifyBST(tree.node);
        
        System.out.println("\nInorder traversal of modified BST (skewed tree):");
        inorder(skewedRoot);
    }
    
    // Function to modify BST into a skewed tree with all nodes in right subtree
    static Node modifyBST(Node root) {
        if (root == null) {
            return null;
        }
        
        Node right = modifyBST(root.right);
        
        root.right = right;
        root.left = null;
        
        Node left = modifyBST(root.left);
        
        if (left == null) {
            return root;
        } else {
            Node node = left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root;
            return left;
        }
    }
    
    // Function to perform inorder traversal of a binary tree
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

