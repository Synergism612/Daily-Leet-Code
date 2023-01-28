package question23;

import utils.ListNode;

public class MergeKLists {

    /**
     * 自写函数
     * 遍历每一个节点比较
     */
    public static ListNode one(ListNode[] lists) {
        ListNode head = new ListNode();
        for (ListNode listNode : lists) {
            if (head.next == null) {
                head.next = listNode;
            } else {
                ListNode node = head;
                while (true) {
                    if (node.next == null) {
                        node.next = listNode;
                        break;
                    }
                    if (listNode == null) {
                        break;
                    }
                    ListNode valNode = new ListNode(listNode.val);
                    if (node.next.val > valNode.val) {
                        valNode.next = node.next;
                        node.next = valNode;
                        listNode = listNode.next;
                    }
                    node = node.next;
                }
            }
        }
        return head.next;
    }


    /**
     * 看来递归确实有可取之处
     * 不是很能看得懂
     */
    public ListNode two(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l+r)>>1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid+1, r));
    }

    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                ListNode.value(new int[]{1, 4, 5}),
                ListNode.value(new int[]{1, 3, 4}),
                ListNode.value(new int[]{2, 6})
        };
        one(listNodes).println();
    }
}
