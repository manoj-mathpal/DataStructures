package git.tree;

import java.util.Stack;

public class BinaryTreeTraversals {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node createBinaryTree() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(9);
        root.right = new Node(15);
        root.right.left = new Node(13);
        root.right.right = new Node(20);
        return root;
    }

    private void traverseInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            System.out.print(" " + root.data);
            root = root.right;
        }
    }

    private void traversePreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(" " + root.data);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            root = root.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversals obj = new BinaryTreeTraversals();
        Node root = obj.createBinaryTree();
        System.out.println("Inorder : ");
        obj.traverseInOrder(root);
        System.out.println("");
        System.out.println("Preorder : ");
        obj.traversePreOrder(root);
    }
}
