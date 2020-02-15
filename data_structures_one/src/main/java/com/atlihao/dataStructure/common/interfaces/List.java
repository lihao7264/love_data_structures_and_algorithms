package com.atlihao.dataStructure.common.interfaces;

/**
 * @author lihao
 * @ClassName List
 * @Since 2020/2/15
 * @Description 链表相关类的公共接口
 *
 */
public interface List<E> {
    /**
     * 没有找到元素，则返回-1
     * 该常量是可以被外界使用的
     * 注意：对外界可见的变量放在接口中
     */
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     * @param element
     */
    void add(E element);

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看元素的下标
     * @param element
     * @return
     */
    int indexOf(E element);
}
