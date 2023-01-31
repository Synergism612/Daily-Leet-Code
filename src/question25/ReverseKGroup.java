package question25;

import utils.ListNode;

public class ReverseKGroup {

    /**
     * 个人觉得可能用递归更好
     * 但是我自己还是写不出来
     * 只能用循环写出来了
     */
    public static ListNode one(ListNode head, int k) {
        //特例
        if (k==1){
            return head;
        }
        //获取到头部节点
        ListNode node = head;
        //结果节点
        ListNode resultHead = new ListNode();
        ListNode resultEnd = resultHead;
        //进入循环
        while (true) {
            //创建部分节点
            ListNode partHead = null;
            //记录末尾节点
            ListNode partEnd = null;
            for (int i = 0; i < k; i++) {
                //数值节点
                ListNode valNode = new ListNode(node.val);
                //添加部分节点的头节点
                if (partHead == null) {
                    partEnd = valNode;
                }
                //添加结果节点的头节点
                if (resultHead.next == null) {
                    resultHead.next = partHead;
                }
                //将读取到的节点倒置
                valNode.next = partHead;
                node = node.next;
                partHead = valNode;
            }
            //部分节点的数据先缓存进去
            resultEnd.next = partHead;
            //将结果末尾调整到实际末尾
            resultEnd = partEnd;
            //检查是否越界，越界则输出
            ListNode checkNode = node;
            for (int i = 0; i < k; i++) {
                //越界，输出
                if (checkNode==null){
                    partEnd.next = node;
                    return resultHead.next;
                }
                //下一个节点
                checkNode = checkNode.next;
            }
        }
    }

    public static void main(String[] args) {
        one(ListNode.value(new int[]{1,2,3,4,5,6}), 2).println();
    }
}
