package phonePe;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int size = getSize(head);
        int pointer=size-n;
        int i=0;
        ListNode current=head;
        while(i<pointer-1){
            current=current.next;
            i++;
        }
        current.next = current.next.next;
        return head;
    }

    public int getSize(ListNode head) {
        if(head==null) return 0;
        int length = 0;
        ListNode current=head;
        if(current==null) return 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        // Find the length of the linked list
//        int length = 0;
//        ListNode current = head;
//        while (current != null) {
//            length++;
//            current = current.next;
//        }
//
//        // Find the position to remove
//        int positionToRemove = length - n;
//
//        // Traverse to the node before the one to be removed
//        ListNode prev = dummy;
//        for (int i = 0; i < positionToRemove; i++) {
//            prev = prev.next;
//        }
//
//        // Remove the nth node from the end
//        prev.next = prev.next.next;
//
//        return dummy.next; // Return the modified list
//    }

    public static void main(String[] args) {
        // Example usage
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();

        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Remove the 2nd node from the end
        ListNode result = solution.removeNthFromEnd(head, 2);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
