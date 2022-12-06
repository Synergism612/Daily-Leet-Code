package question2;

public class AddingTwoNumbers {
    /**
     * 迭代解法
     * 先将头部处理完成
     * 进入循环，对每一位进行操作
     * 时间复杂度 O(max(m,n)) m,n分别是两个链表的的长度
     * 空间复杂度 O(1)
     */
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

    /**
     * 递归循环解法
     * 注意这里是双递归
     * 第一次递归只会将 sum % 10 的值写入
     * 第二次递归则会对大于 10 的部分进行下一个节点加 1 的处理
     * 时间复杂度 O(max(m,n)) m,n分别是两个链表的的长度
     * 空间复杂度 O(max(m,n)) m,n分别是两个链表的的长度
     */
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

    /**
     * 优化的迭代解法
     * 时间复杂度 O(max(m,n)) m,n分别是两个链表的的长度
     * 空间复杂度 O(1)
     */
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

    /**
     * 链表输出方法
     *
     * @param head 链表头部节点
     */
    public static void out(ListNode head) {
        System.out.print(head.val + " ");
        if (head.next == null) {
            System.out.println(">");
            return;
        }
        out(head.next);
    }
}
