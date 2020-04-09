package git.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(30);
        root.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(5);
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
            if (stack.isEmpty()) {
                return;
            } else {
                if (stack.peek().right == null) {
                    root = stack.pop();
                    System.out.print(" " + root.data);
                    if (root == stack.peek().right) {
                        System.out.print(" " + stack.peek().data);
                        stack.pop();
                    }
                }
                if (!stack.isEmpty())
                    root = stack.peek().right;

                else
                    root = null;

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

    private int findMaxElement(Node root) {
        int max = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            if (root.data > max)
                max = root.data;
            root = root.right;
        }
        return max;
    }

    private int findMinElement(Node root) {
        int min = Integer.MAX_VALUE;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            if (root.data < min)
                min = root.data;
            root = root.right;
        }
        return min;
    }

    private boolean isElementPresentInBinaryTree(Node root, int value) {
        boolean isElementPresent = Boolean.FALSE;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            if (root.data == value) {
                isElementPresent = true;
                break;
            }
            root = root.right;
        }
        return isElementPresent;
    }

    private Node insertNodeInBinaryTree(Node root, int data) {
        while (root != null) {
            if (root.left == null) {
                root.left = new Node(data);
            }
            root = root.left;
        }
        return root;
    }

    private int findSize(Node root) {
        int count = 0;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            root = stack.pop();
            root = root.right;
            count++;
        }
        return count;
    }

    private int findHeightOfBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    level++;
                }
            } else {
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
        }
        return level;
    }

    private void printBinaryTreeZigZag(Node root) {
        Stack<Node> currentLevel = new Stack<>(), nextLevel = new Stack<>();
        int leftToRight = 1;
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            Node temp = currentLevel.pop();
            if (temp != null) {
                System.out.print(" " + temp.data);
                if (leftToRight == 1) {
                    if (temp.left != null)
                        nextLevel.push(temp.left);
                    if (temp.right != null)
                        nextLevel.push(temp.right);
                } else {
                    if (temp.right != null)
                        nextLevel.push(temp.right);
                    if (temp.left != null)
                        nextLevel.push(temp.left);
                }
            }
            if (currentLevel.isEmpty()) {
                leftToRight = 1-leftToRight;
                HashMap<String,Stack<Node>> stacks = swapStacks(currentLevel, nextLevel);
                currentLevel = stacks.get("currentLevel");
                nextLevel = stacks.get("nextLevel");
            }
        }
    }

    private HashMap<String,Stack<Node>> swapStacks(Stack<Node> n1,Stack<Node> n2) {
        HashMap<String,Stack<Node>> stacks = new HashMap<>();
        List<Node> currentLevelNodes = new ArrayList<>();
        List<Node> nextLevelNodes = new ArrayList<>();
        while (!n1.isEmpty()) {
            currentLevelNodes.add(n1.pop());
        }
        while (!n2.isEmpty()) {
            nextLevelNodes.add(n2.pop());
        }
        for(int i=currentLevelNodes.size()-1;i>=0;i--) {
            n2.push(currentLevelNodes.get(i));
        }
        stacks.put("nextLevel", n2);
        for(int i=nextLevelNodes.size()-1;i>=0;i--) {
            n1.push(nextLevelNodes.get(i));
        }
        stacks.put("currentLevel", n1);
        return stacks;
    }

    public static void main(String[] args) {
        BinaryTreeTraversals obj = new BinaryTreeTraversals();
        Node root = obj.createBinaryTree();
//        System.out.println("Inorder : ");
//        obj.traverseInOrder(root);
//        System.out.println("");
//        System.out.println("Preorder : ");
//        obj.traversePreOrder(root);
////        System.out.println("");
////        System.out.println("Postorder : ");
////        obj.traversePostOrder(root);
//        System.out.println("");
//        System.out.println("Postorder by recursion : ");
//        obj.traversePostOrderByRecursion(root);
//        System.out.println("");
//        System.out.println("preorder by recursion : ");
//        obj.traversePreOrderByRecursion(root);
//        System.out.println("");
//        System.out.println("inorder by recursion : ");
//        obj.traverseInOrderByRecursion(root);
        // System.out.println("max element is : " + obj.findMaxElement(root));
        // System.out.println("min element is : " + obj.findMinElement(root));
        // System.out.println(obj.isElementPresentInBinaryTree(root,30));
        // System.out.println("size is : " + obj.findSize(root));
        // root = obj.insertNodeInBinaryTree(root, 99);
        // System.out.println("height of the tree is : " +
        // obj.findHeightOfBinaryTree(root));
        obj.printBinaryTreeZigZag(root);
    }
}
