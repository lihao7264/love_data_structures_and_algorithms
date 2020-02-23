package com.atlihao.dataStructure.three.linked.leetcode;

/**
 * @author lihao
 * @ClassName RemoveElements
 * @Since 2020/2/23
 * @Description 203. 移除链表元素
 * 说明：删除链表中等于给定值val的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode listNode = removeElements2(node1, 6);
    }


    /**
     * 方法一：递归法
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next:head;
    }

    /**
     * 方法二：借助辅助的哨兵节点(增加一个前置节点0)
     * ①初始化哨兵节点为 ListNode(0) 且设置 sentinel.next = head。
     * ②初始化两个指针 current 和 prev 指向当前节点和前继节点。
     * ③当 current != null：
     * a、比较当前节点和要删除的节点：
     * 1）若当前节点就是要删除的节点：则 prev.next = current.next。
     * 2）否则设 prve = current。
     * b、遍历下一个元素：current = current.next。
     * ④返回sentinel.next。
     * <p>
     * 时间复杂度：O(N)，只遍历了一次。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return sentinel.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
