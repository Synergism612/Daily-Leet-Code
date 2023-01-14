package question19;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void println() {
        System.out.println(this.val);
        if (this.next == null) {
            return;
        }
        this.next.println();
    }

    static ListNode value(int[] values) {
        ListNode head = null;
        ListNode node = null;
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
        assert head != null;
        head.println();
        return head;
    }
}
