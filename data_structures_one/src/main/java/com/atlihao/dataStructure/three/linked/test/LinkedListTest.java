package com.atlihao.dataStructure.three.linked.test;

import com.atlihao.dataStructure.common.interfaces.List;
import com.atlihao.dataStructure.three.linked.LinkedList;

/**
 * @author lihao
 * @ClassName LinkedListTest
 * @Since 2020/2/15
 * @Description LinkedList类的测试类
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(list.size(), 40);
        //[10, 30, 40]
        list.remove(1);
        System.out.println(list);
    }
}
