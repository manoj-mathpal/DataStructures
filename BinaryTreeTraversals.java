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

    private void traversePostOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) {
                return;
            }
            else {
                if(stack.peek().right==null) {
                    root = stack.pop();
                    System.out.print(" " + root.data);
                    if(root==stack.peek().right) {
                        System.out.print(" " + stack.peek().data);
                        stack.pop();
                    }
                }
                if(!stack.isEmpty()) 
                    root=stack.peek().right;
                
                else 
                    root=null;
                
            }
            stack.clear();
        }
    }

    private void traversePostOrderByRecursion(Node root) {
        if (root != null) {
            traversePostOrderByRecursion(root.left);
            traversePostOrderByRecursion(root.right);
            System.out.print(" " + root.data);
        }
    }

    private void traversePreOrderByRecursion(Node root) {
        if (root != null) {
            System.out.print(" " + root.data);
            traversePreOrderByRecursion(root.left);
            traversePreOrderByRecursion(root.right);

        }
    }

    private void traverseInOrderByRecursion(Node root) {
        if (root != null) {
            traverseInOrderByRecursion(root.left);
            System.out.print(" " + root.data);
            traverseInOrderByRecursion(root.right);
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
        System.out.println("");
        System.out.println("Postorder : ");
        obj.traversePostOrder(root);
        System.out.println("");
        System.out.println("Postorder by recursion : ");
        obj.traversePostOrderByRecursion(root);
        System.out.println("");
        System.out.println("preorder by recursion : ");
        obj.traversePreOrderByRecursion(root);
        System.out.println("");
        System.out.println("inorder by recursion : ");
        obj.traverseInOrderByRecursion(root);
    }
}
