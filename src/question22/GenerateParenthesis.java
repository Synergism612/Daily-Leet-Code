package question22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {

    /**
     * 一种树的思想，值得学习
     * 树的模型，以及修剪的概念
     * <p>
     * 深度优先算法(回调算法)
     * 到达最深后自动回调
     */
    public static List<String> one(int n) {
        List<String> result = new ArrayList<>();
        // 特判
        if (n == 0) {
            return result;
        }

        dfs("", 0, 0, n, result);
        return result;
    }

    /**
     * 递归思维我还运用不熟练，应该多用，该题中若是使用循环，就需要回调
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param result 结果集
     */
    private static void dfs(String curStr, int left, int right, int n, List<String> result) {
        // 深度最深，开始返回
        if (left == n && right == n) {
            result.add(curStr);
            return;
        }
        // 剪枝
        if (left < right) {
            return;
        }
        // 左边小就加 (
        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, result);
        }
        // 右边小就加 )
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, result);
        }
    }

    /**
     * 用于存储的节点类
     */
    static class Node {
        /**
         * 当前得到的字符串
         */
        private String result;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.result = str;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 广度优先算法
     * 注意和深度的区别
     * 循环方式与实现方法
     */
    public static List<String> two(int n) {
        List<String> result = new ArrayList<>();
        //特例
        if (n == 0) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        //向队列中添加初始量
        queue.offer(new Node("", n, n));

        //不为空时
        while (!queue.isEmpty()) {
            //提取节点(删除并返回)
            Node node = queue.poll();
            //符合写入结果集条件
            if (node.left == 0 && node.right == 0) {
                //写入结果集
                result.add(node.result);
            }
            //若左侧未归0
            if (node.left > 0) {
                //写入队列
                queue.offer(new Node(node.result + "(", node.left - 1, node.right));
            }
            //若右侧未归0
            if (node.right > 0 && node.left < node.right) {
                //写入队列
                queue.offer(new Node(node.result + ")", node.left, node.right - 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = two(4);
        System.out.println(result);
        System.out.println(result.size());
    }
}
