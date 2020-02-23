package com.atlihao.dataStructure.three.linked;

import com.atlihao.dataStructure.common.abstracts.AbstractList;

/**
 * @author lihao
 * @ClassName LinkedList2
 * @Since 2020/2/15
 * @Description 链表类--增加虚拟头结点
 */
@SuppressWarnings("unchecked")
public class LinkedList2<E> extends AbstractList<E> {

    /**
     * 链表的第一个节点
     */
    private Node<E> first;

    public LinkedList2() {
        this.first = new Node<>(null, null);
    }

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
        rangeCheckForAdd(index);
        //获取要插入位置的前一个节点（0下标的前面节点是first）
        Node<E> prev = index == 0 ? first : node(index - 1);
        //修改前一个节点以及创建当前节点(并设置next值为前一个节点的next值)
        prev.next = new Node<>(element, prev.next);
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        //被删除的节点对象
        Node<E> prev = index == 0 ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = prev.next.next;
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first.next;
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
        Node<E> node = first.next;
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
        Node<E> node = first.next;
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
