package dataStructure.linkedList;

import java.util.ArrayList;
import java.util.Queue;

import ds.list.linkedList.RemoveDuplicates;

public class LinkedList {

    static Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node createLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        return head;
    }
    
    private Node createOtherLinkedList() {
        Node head = new Node(7);
        head.next = new Node(8);
        head.next.next = new Node(9);
        return head;
    }

    private static Node removeDuplicates(Node head) {
        if (head == null)
            return null;
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    private Node FindKthElement(Node head, int k) {
        if (k <= 0)
            return null;
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }
        if (p2 == null)
            return null;
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    private void printList(Node head) {
        Node current = head;
        if (head == null) {
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private boolean isPallindrome(Node head) {
        Node node = head;
        boolean flag = false;
        ArrayList<Node> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int counter = 0;
        for (int i = 0; i <= list.size() / 2; i++) {
            counter++;
            if (list.get(i).data == list.get(list.size() - counter).data) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Node partitionList(Node head, int value) {
        Node beforeStart = null;
        Node afterStart = null;
        while (head != null) {
            Node next = head.next;
            if (head.data < value) {
                head.next = beforeStart;
                beforeStart = head;
            } else {
                head.next = afterStart;
                afterStart = head;
            }
            head = next;
        }
        if (beforeStart == null)
            return afterStart;
        Node node = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;
        return node;
    }

    private Node findStartOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    private Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node pre = null;
        while (current != null) {
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        if (head != null) {
            head.next = current;
        }
        if (current != null) {
            head.next = reverseList(current);
        }
        return pre;
    }

    private Node reverseInGroups(Node head, int value) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node pre = null;
        int count = 0;
        while (current != null && count < value) {
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            count++;
        }
        if (head != null) {
            head.next = current;
        }
        if (current != null) {
            head.next = reverseInGroups(current, value);
        }
        return pre;
    }

    private Node reverseKAlternateGroups(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node pre = null;
        int count = 0;
        while (current != null && count < k) {
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            count++;
        }
        if (head != null) {
            head.next = current;
        }
        count = 0;
        while (current != null && count < k - 1) {
            current = current.next;
        }
        if (current != null) {
            current.next = reverseInGroups(current.next, k);
        }
        return pre;
    }
    
    private void findMergePoint() {
        LinkedList obj = new LinkedList();
        Node firstList = obj.createLinkedList();
        Node secondList = obj.createOtherLinkedList();
        Node node = findMergePoint(firstList, secondList);
        if (node == null)
            System.out.println("No merging point found");
        else
            System.out.println("Merging Point is: " + node.data);
    }

    private Node findMergePoint(Node list1, Node list2) {
        int lengthOfFirstList = findLength(list1);
        int lengthOfSecondList = findLength(list2);
        int difference = Math.abs(lengthOfFirstList - lengthOfSecondList);
        if (lengthOfFirstList > lengthOfSecondList) {
            while(difference != 0) {
                list1 = list1.next;
                difference--;
            }
        } else if (lengthOfSecondList > lengthOfFirstList) {
            while(difference != 0) {
                list2 = list2.next;
                difference--;
            }
        }
        while (list1 != null && list2 != null && list1.data != list2.data) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1;
    }

    private int findLength(Node head) {
        Node current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        head = obj.createLinkedList();
        // head = obj.removeDuplicates(head);
        // obj.printList(head);
        // Node kthNode = obj.FindKthElement(head, 5);
        // System.out.println("kth node is : " + kthNode.data);
        // removeDuplicates(head);
        // System.out.println("is list pallindrome : " + obj.isPallindrome(head));
        // Node node = obj.partitionList(head, 5);
        // Node node = obj.findStartOfLoop(head);
        // System.out.println(node.data);
        // Node node = obj.reverseInGroups(head, 3);
        // System.out.println("reverse by group: ");
        // obj.printList(node);
        // Node node = obj.reverseList(head);
        // obj.printList(node);
        // Node node = obj.reverseKAlternateGroups(head, 3);
        // System.out.println("reverse by k alternate nodes: ");
        // obj.printList(node);            
        // obj.findMergePoint();

    }

}
