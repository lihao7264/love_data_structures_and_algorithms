package com.atlihao.dataStructure.three.linked.leetcode;

/**
 * @author lihao
 * @ClassName MiddleNode
 * @Since 2020/2/23
 * @Description 876. 链表的中间结点
 * 说明：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * ①示例1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * ②示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class MiddleNode {

    /**
     * 方法一：两次迭代法
     * 时间复杂度：O(N)，其中 N是给定列表中的节点数目。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curret = head;
        Integer size = -1;
        while (curret != null) {
            size++;
            curret = curret.next;
        }
        int middle = (size + 1) / 2;
        int index = -1;
        while (curret != null) {
            index++;
            if (middle == index) {
                return curret;
            }
        }
        return null;
    }


    /**
     * 方法二：数组中介法
     *  按顺序将每个结点放入数组中。
     *  然后中间结点就是 数组[数组.Length/2]。
     *
     * 时间复杂度：O(N)，其中 N是给定列表中的节点数目。
     * 空间复杂度：O(N)，数组用去的空间。
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode[] listNodes = new ListNode[100];
        int t = 0;
        while (head != null) {
            listNodes[t++] = head;
            head = head.next;
        }
        return listNodes[t/2];
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
