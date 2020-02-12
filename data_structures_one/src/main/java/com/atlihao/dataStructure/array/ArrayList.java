package com.atlihao.dataStructure.array;

/**
 * @author lihao
 * @ClassName ArrayList
 * @Since 2020/2/9
 * @Description 动态数组类
 */
public class ArrayList {

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素
     */
    private int[] elements;

    /**
     * 默认容量为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 没有找到元素，则返回-1
     */
    private static final int ELEMENT_NOT_FOUND = -1;


    public ArrayList() {
        //默认10个大小的数组
        this(DEFAULT_CAPACITY);
    }

    /**
     * 可以控制初始化保存元素的数组的大小
     *
     * @param capacity 容量
     */
    public ArrayList(int capacity) {
        //传入的capacity小于10，则都为10
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        //只需要修改size的值，size会控制其它方法(优点：不需要释放内存，提高了性能，因为这个集合很可能会再次使用，add的时候，直接覆盖原有值即可)
        size = 0;
    }

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(int element) {
        //indexOf方法没有返回元素不存在，就包含
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到最后面
     *
     * @param element
     */
    public void add(int element) {
        add(size, element);
    }

    /**
     * 返回index位置对应的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        //校验入参合法性
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素
     */
    public int set(int index, int element) {
        //校验入参合法性
        rangeCheck(index);
        //取出原来的元素
        int old = elements[index];
        //新元素覆盖旧元素
        elements[index] = element;
        return old;
    }

    /**
     * 往index位置添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        //校验入参合法性（插入允许等于size，也就是追加）
        rangeCheckForAdd(index);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置对应的元素
     *
     * @param index
     * @return 返回要删除的元素
     */
    public int remove(int index) {
        //校验入参合法性
        rangeCheck(index);
        int old = elements[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 查看元素的位置
     *
     * @param element
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /*封装统一的异常格式*/
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }

    /*检查下标*/
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /*为添加方法，检查下标*/
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    @Override
    public String toString() {
        // size=3, [99,88,77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            //方法二：如果不是第一个下标的话，则先拼接上,号
            //优点：这里不用少做一个减法运算。（所以这个更加好）
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);

            //方法一：不是最后一个元素，则拼接上,号
//            if (i != size - 1) {
//                string.append(", ");
//            }

        }
        string.append("]");
        return string.toString();
    }
}
