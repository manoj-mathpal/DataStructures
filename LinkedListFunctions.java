package arrayStringProblems;

public class LinkedListFunctions {

    Node head;
    Node tail;
    Node current;

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public LinkedListFunctions addNode(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
        return this;
    }

    public LinkedListFunctions printList() {
        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
        return this;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }

    public int getSize() {
        int length = 0;
        if(head==null) return 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public boolean isLoopPresent(){
        if(head==null) return false;
        Node slowPointer = head;
        Node fastPointer = head.next;
        while(slowPointer!=fastPointer){
            if(fastPointer==null || fastPointer.next==null){
                return false;
            }
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }
        return true;
    }

    public int findMiddleElement(){
        int startingIndex=0;
        current=head;
        if(current==null) {
            return -1;
        }
        int len = getSize();
        int middleIndex = len/2;
        while(current!=null && startingIndex<middleIndex ){
            startingIndex++;
            current=current.next;
        }
        return current.data;
    }

    public Node reverseLinkedList(){
        Node prev = null;
        while(head!=null){
            Node next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        printList(prev);
        System.out.println("-------");
       return prev;

    }

    public Node removeNthElement(int n){
        if(head==null) return null;
        head= reverseLinkedList();
        remove(head,n);
        return reverseLinkedList();
    }

    public void remove(Node node, int n){
        int i=1;
        if(node.next==null && n==1) node=head.next;
        if(n==1) node=node.next;
        else if(n==2) node.next=node.next.next;
        else{
            while(i<n-1){
                node=node.next;
            }
            node.next=node.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedListFunctions obj = new LinkedListFunctions();
        obj.addNode(1)
                .addNode(2)
                .addNode(3)
                .addNode(4)
                .addNode(5);
        obj.removeNthElement(2);
        obj.printList();
       // obj.reverseLinkedList();
       // obj.reverseLinkedList();

    }
}