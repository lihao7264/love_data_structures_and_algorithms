package com.atlihao.dataStructure.common.abstracts;

import com.atlihao.dataStructure.common.interfaces.List;

/**
 * @author lihao
 * @ClassName AbstractList
 * @Since 2020/2/15
 * @Description 链表相关的公共代码类
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到最后面
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /*封装统一的异常格式*/
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }

    /*检查下标*/
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /*为添加方法，检查下标*/
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
