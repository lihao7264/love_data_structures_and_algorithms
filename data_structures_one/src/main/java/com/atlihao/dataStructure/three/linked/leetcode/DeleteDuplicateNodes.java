package com.atlihao.dataStructure.three.linked.leetcode;

/**
 * @author lihao
 * @ClassName DeleteDuplicateNodes
 * @Since 2020/2/23
 * @Description 83. 删除排序链表中的重复元素
 * 说明：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * ①示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * ②示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicateNodes {

    /**
     * 一、迭代法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
