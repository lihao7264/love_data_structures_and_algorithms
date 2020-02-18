package com.atlihao.dataStructure.three.linked.leetcode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author lihao
 * @ClassName DeleteNode
 * @Since 2020/2/15
 * @Description 237. 删除链表中的节点
 * 说明：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * a、链表至少包含两个节点。
 * b、链表中所有节点的值都是唯一的。
 * c、给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * d、不要从你的函数中返回任何结果。
 */
public class DeleteNode {

    public static void main(String[] args) {

    }

    /**
     * 解法一：将后面的节点，向前覆盖
     *
     * @param node 要删除的节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
