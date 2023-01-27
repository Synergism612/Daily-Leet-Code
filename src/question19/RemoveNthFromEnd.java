package question19;

import utils.ListNode;

public class RemoveNthFromEnd {

    /**
     * 原理是缓存距离读取位置为n的节点
     * 若读取到结束，就删除缓存的节点
     * 我自己写的不够最优
     */
    public static ListNode one(ListNode head, int n) {
        ListNode numberBefore = head;
        ListNode nowNode = head;
        for (int i = 0; i < n-1; i++) {
            nowNode = nowNode.next;
        }
        if (nowNode.next==null){
            head = numberBefore.next;
            return head;
        }
        while (nowNode.next.next!=null){
            numberBefore = numberBefore.next;
            nowNode = nowNode.next;
        }
        numberBefore.next = numberBefore.next.next;
        return head;
    }

    /**
     * 妙在第一行，将head往后挪了一位
     * 我自写方法中需要判断两次，挪后一位使得两次判断重合
     * 故而只需要判断一次
     * 更加精妙
     */
    public static ListNode two(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode p1 = head;
        ListNode p2 = head;
        while (n-- > 0) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4,5,6};
        int n = 5;
        ListNode head = ListNode.value(values);
        System.out.println("开始运行");
        ListNode result = one(head,n);
        result.println();
    }
}
