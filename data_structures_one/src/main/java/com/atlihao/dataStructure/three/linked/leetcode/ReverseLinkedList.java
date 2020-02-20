package com.atlihao.dataStructure.three.linked.leetcode;

/**
 * @author lihao
 * @ClassName ReverseLinkedList
 * @Since 2020/2/20
 * @Description 206. 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 方法一：递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        //链表为空或者链表只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        //一层
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 方法二：迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        //（head的next指向newHead，然后newHead指向head，然后head指向head原来的next节点）
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
