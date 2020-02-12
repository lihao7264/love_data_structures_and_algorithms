package com.atlihao.dataStructure.array.test;

import com.atlihao.dataStructure.array.ArrayList;

/**
 * @author lihao
 * @ClassName ArrayListTest
 * @Since 2020/2/9
 * @Description 动态数组类的测试类
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //new是向堆空间申请内存
        ArrayList list = new ArrayList();
        list.add(99);
        list.add(88);
        list.add(77);
        list.add(66);
        list.add(55);

//        list.remove(2);
        list.add(1,100);
        list.add(list.size(),100);

        System.out.println(list);
    }
}
