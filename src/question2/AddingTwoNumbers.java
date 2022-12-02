package question2;

public class AddingTwoNumbers {
    public static ListNode one(ListNode l1, ListNode l2) {
        int n = 0;
        int sum;

        sum = l1.val + l2.val + n;
        n = 0;
        if (sum >= 10) {
            sum = sum % 10;
            n = 1;
        }

        ListNode temp = new ListNode(sum, new ListNode());
        ListNode head = temp;
        while (true) {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                if (n != 0) {
                    temp.next = new ListNode(n);
                } else {
                    temp.next = null;
                }
                break;
            } else {
                if (l1 == null) {
                    l1 = new ListNode();
                }
                if (l2 == null) {
                    l2 = new ListNode();
                }

                sum = l1.val + l2.val + n;
                n = 0;
                if (sum >= 10) {
                    sum = sum % 10;
                    n = 1;
                }
                temp.next = new ListNode(sum, new ListNode());
            }
            temp = temp.next;
        }

        return head;
    }

    public static ListNode two(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int sum = l1.val + l2.val;

        ListNode result = new ListNode(sum % 10);
        result.next = two(l1.next, l2.next);

        if (sum / 10 > 0) {
            result.next = two(result.next, new ListNode(1));
        }

        return result;
    }

    public static ListNode three(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        int n = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + n;

            n = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (n == 1) {
            temp.next = new ListNode(n);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        out(one(l1, l2));
        out(two(l1, l2));
        out(three(l1, l2));
    }

    public static void out(ListNode head) {
        System.out.print(head.val + " ");
        if (head.next == null) {
            System.out.println(">");
            return;
        }
        out(head.next);
    }
}
