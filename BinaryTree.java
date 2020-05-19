package dataStructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    static Node node;
    static Node node1;
    static Node node2;
    private static int[] arr = { 25, 10, 30, 90, 60, 50, 75 };
    private static int nPath;

    int depth = 0;
    boolean isNodeFound = false;
    static HashMap<Integer, List<Integer>> verticalNodes = new HashMap<>();

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node createBinaryTree() {
        Node root = new Node(50);
        root.left = new Node(25);
        node1 = root.left.left = new Node(10);
        node2 = root.left.right = new Node(30);
        root.left.right.left = new Node(27);
        root.right = new Node(75);
        root.right.left = new Node(60);
        node = root.right.right = new Node(90);
        return root;
    }

    private Node createANode() {
        Node node = new Node(60);
        return node;
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

    private int findHeightOfBinaryTreeByRecursion(Node root) {
        int leftHeight, rightHeight;
        if (root == null)
            return 0;
        leftHeight = findHeightOfBinaryTreeByRecursion(root.left);
        rightHeight = findHeightOfBinaryTreeByRecursion(root.right);
        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    private int findDepthOfANodeInBinaryTreeByRecursion(Node root, Node node) {
        if (isNodeFound == true)
            root = null;

        if (root == null) {
            return 0;
        }
        if (root != node) {
            depth = depth + 1;
        }
        if (root == node)
            isNodeFound = true;

        findDepthOfANodeInBinaryTreeByRecursion(root.left, node);
        findDepthOfANodeInBinaryTreeByRecursion(root.right, node);
        return depth;
    }

    private int findDepthOfANodeInBinaryTree(Node root, Node node) {
        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (root == node)
                return depth;
            if (root == null) {
                if (!queue.isEmpty()) {
                    depth++;
                    queue.add(null);
                }
            } else {
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
        }
        return depth;
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
                leftToRight = 1 - leftToRight;
                HashMap<String, Stack<Node>> stacks = swapStacks(currentLevel, nextLevel);
                currentLevel = stacks.get("currentLevel");
                nextLevel = stacks.get("nextLevel");
            }
        }
    }

    private HashMap<String, Stack<Node>> swapStacks(Stack<Node> n1, Stack<Node> n2) {
        HashMap<String, Stack<Node>> stacks = new HashMap<>();
        List<Node> currentLevelNodes = new ArrayList<>();
        List<Node> nextLevelNodes = new ArrayList<>();
        while (!n1.isEmpty()) {
            currentLevelNodes.add(n1.pop());
        }
        while (!n2.isEmpty()) {
            nextLevelNodes.add(n2.pop());
        }
        for (int i = currentLevelNodes.size() - 1; i >= 0; i--) {
            n2.push(currentLevelNodes.get(i));
        }
        stacks.put("nextLevel", n2);
        for (int i = nextLevelNodes.size() - 1; i >= 0; i--) {
            n1.push(nextLevelNodes.get(i));
        }
        stacks.put("currentLevel", n1);
        return stacks;
    }

    private void verticalTraversal(Node root, int key, HashMap<Integer, List<Integer>> map) {
        if (root == null)
            return;
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(root.data);
        verticalTraversal(root.left, key - 1, map);
        verticalTraversal(root.right, key + 1, map);
    }

    private void printVerticalNodes() {
        for (Collection<Integer> collection : verticalNodes.values()) {
            System.out.print(" " + collection);
        }
    }

    public static int heightOfTree(Node root) {
        if (null == root)
            return 0;
        int hLeftSub = heightOfTree(root.left);
        int hRightSub = heightOfTree(root.right);
        return Math.max(hLeftSub, hRightSub) + 1;
    }

    int diameter(Node root) {
        if (root == null)
            return 0;
        int lheight = heightOfTree(root.left);
        int rheight = heightOfTree(root.right);
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

    }

    public Node lca(Node root, Node node1, Node node2) {
        if (null == root) {
            return root;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        Node left = lca(root.left, node1, node2);
        Node right = lca(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }
        if (left != null)
            return left;
        else
            return right;
    }

    public void root2LeafPath(Node root, int[] path) {
        nPath = 0;
        processPath(root, path, 0);
    }

    private void processPath(Node root, int[] path, int index) {
        if (null == root) {
            return;
        }
        path[index++] = root.data;
        if (root.left == null && root.right == null) {
            print(path, index);
            return;
        }
        processPath(root.left, path, index);
        processPath(root.right, path, index);
        // return;
    }

    private void print(int[] path, int index) {
        System.out.printf("Root to Leaf path %d : ", ++nPath);
        System.out.println(Arrays.toString(Arrays.copyOf(path, index)));
        return;
    }

    private boolean isBinaryTreeBalanced(Node root) {
        if (getHeight(root) == -1)
            return false;
        return true;
    }

    private int getHeight(Node root) {
        if (root == null)
            return 0;
        int lHeight = getHeight(root.left);
        if (lHeight == -1)
            return -1;
        int rHeight = getHeight(root.right);
        if (rHeight == -1)
            return -1;
        int diff = lHeight - rHeight;
        if (Math.abs(diff) > 1)
            return -1;
        return (Math.max(lHeight, rHeight) + 1);
    }

    private Node createBinarySearchTreeFromGivenArray(int[] ary) {
        int[] sortedArray = sortArray(ary);
        return createBinarySearchTreeFromGivenArray(sortedArray, 0, sortedArray.length - 1);
    }

    private Node createBinarySearchTreeFromGivenArray(int[] ary, int low, int high) {
        if (high < low)
            return null;
        int mid = (low + high) / 2;
        Node root = new Node(ary[mid]);
        root.left = createBinarySearchTreeFromGivenArray(ary, low, mid - 1);
        root.right = createBinarySearchTreeFromGivenArray(ary, mid + 1, high);
        return root;
    }

    private int[] sortArray(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[i] > ary[j]) {
                    ary[i] = ary[i] + ary[j];
                    ary[j] = ary[i] - ary[j];
                    ary[i] = ary[i] - ary[j];
                }
            }
        }
        return ary;
    }

    public static void main(String[] args) {
        BinaryTree obj = new BinaryTree();
        Node root = obj.createBinaryTree();
        // System.out.println("Inorder : ");
        // obj.traverseInOrder(root);
        // System.out.println("");
        // System.out.println("Preorder : ");
        // obj.traversePreOrder(root);
        // System.out.println("");
        // System.out.println("Postorder : ");
        // obj.traversePostOrder(root);
        // System.out.println("");
        // System.out.println("Postorder by recursion : ");
        // obj.traversePostOrderByRecursion(root);
        // System.out.println("");
        // System.out.println("preorder by recursion : ");
        // obj.traversePreOrderByRecursion(root);
        // System.out.println("");
        // System.out.println("inorder by recursion : ");
        // obj.traverseInOrderByRecursion(root);
        // System.out.println("max element is : " + obj.findMaxElement(root));
        // System.out.println("min element is : " + obj.findMinElement(root));
        // System.out.println(obj.isElementPresentInBinaryTree(root,30));
        // System.out.println("size is : " + obj.findSize(root));
        // root = obj.insertNodeInBinaryTree(root, 99);
        // System.out.println("height of the tree is : " +
        // obj.findHeightOfBinaryTree(root));
        // obj.printBinaryTreeZigZag(root);
        // System.out.println("depth of node is : " +
        // obj.findDepthOfANodeInBinaryTree(root,node));
        // System.out.println("height of binary tree by recursion : " +
        // obj.findHeightOfBinaryTreeByRecursion(root));
        // int depth = obj.findDepthOfANodeInBinaryTreeByRecursion(root, node);
        // System.out.println("depth is : " + depth);
        // obj.verticalTraversal(root, 0, verticalNodes);
        // obj.printVerticalNodes();
        // int diameter = obj.diameter(root);
        // System.out.println("diameter of the tree is : " + diameter);
        // Node lcaNode = obj.lca(root, node1, node2);
        // System.out.println("lowest common ancestor is : " + lcaNode.data);
        // arr = new int[obj.findSize(root)];
        // obj.root2LeafPath(root, arr);
        // System.out.println("is tree balanced : " + obj.isBinaryTreeBalanced(root));
        // Node nodeRoot = obj.createBinarySearchTreeFromGivenArray(arr);
        // obj.traverseInOrderByRecursion(nodeRoot);
    }
}
