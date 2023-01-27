package question21;

import utils.ListNode;

public class MergeTwoLists {

    /**
     * 遍历两链表
     * 逐个比对
     * 写入结果链表
     */
    public static ListNode one(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode result = head;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
                result = result.next;
                continue;
            }
            if (list2 == null) {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
                result = result.next;
                continue;
            }
            if (list1.val > list2.val) {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            }else {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            result = result.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.value(new int[]{-9,3});
        ListNode listNode2 = ListNode.value(new int[]{5,7});
        one(listNode1,listNode2).println();
    }
}
