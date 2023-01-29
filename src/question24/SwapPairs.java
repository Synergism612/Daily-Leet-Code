package question24;

import utils.ListNode;

public class SwapPairs {

    public static ListNode one(ListNode head) {
        head = new ListNode(0,head);
        ListNode node = head;
        while (node.next != null && node.next.next != null){
            ListNode valNode = new ListNode(node.next.next.val);
            node.next.next = node.next.next.next;
            valNode.next = node.next;
            node.next = valNode;
            node = node.next.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        one(ListNode.value(new int[]{1,2,3,4})).println();
    }
}
