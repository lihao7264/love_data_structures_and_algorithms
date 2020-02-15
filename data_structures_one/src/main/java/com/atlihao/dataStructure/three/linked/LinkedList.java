package com.atlihao.dataStructure.three.linked;

import com.atlihao.dataStructure.common.abstracts.AbstractList;

/**
 * @author lihao
 * @ClassName LinkedList
 * @Since 2020/2/15
 * @Description 链表类
 */
@SuppressWarnings("unchecked")
public class LinkedList<E> extends AbstractList<E> {

    /**
     * 链表的第一个节点
     */
    private Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            //替换first值
            first = new Node<>(element, first);
        } else {
            //获取要插入位置的前一个节点
            Node<E> prev = node(index - 1);
            //修改前一个节点以及创建当前节点(并设置next值为前一个节点的next值)
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        //被删除的节点对象
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else if (index == size - 1) {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = null;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        // size=3, [99,88,77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            //方法二：如果不是第一个下标的话，则先拼接上,号
            //优点：这里不用少做一个减法运算。（所以这个更加好）
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
            //方法一：不是最后一个元素，则拼接上,号
//            if (i != size - 1) {
//                string.append(", ");
//            }

        }
        string.append("]");
        return string.toString();
    }

    /**
     * 获取index位置对应的节点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 链表的节点类：静态内部类
     */
    private static class Node<E> {
        /**
         * 当前节点存储的元素
         */
        E element;

        /**
         * 下一个节点
         */
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("node finalize");
        }
    }
}
