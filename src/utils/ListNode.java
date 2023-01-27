package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void println() {
        System.out.print(this.val+"->");
        if (this.next == null) {
            System.out.print("null\n");
            return;
        }
        this.next.println();
    }

    public static ListNode value(int[] values) {
        ListNode head = null;
        ListNode node = null;
        if (values.length==0){
            head = new ListNode();
        }else {
            for (int value : values) {
                if (node == null) {
                    node = new ListNode(value);
                } else {
                    node.next = new ListNode(value);
                    node = node.next;
                }
                if (head == null) {
                    head = node;
                }
            }
        }
        head.println();
        return head;
    }
}
