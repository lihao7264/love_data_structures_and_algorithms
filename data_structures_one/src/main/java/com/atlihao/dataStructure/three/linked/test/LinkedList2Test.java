package com.atlihao.dataStructure.three.linked.test;

import com.atlihao.dataStructure.common.interfaces.List;
import com.atlihao.dataStructure.three.linked.LinkedList;
import com.atlihao.dataStructure.three.linked.LinkedList2;

/**
 * @author lihao
 * @ClassName LinkedList2Test
 * @Since 2020/2/23
 * @Description LinkedList2的测试类
 */
public class LinkedList2Test {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList2<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(list.size(), 40);
        //[10, 30, 40]
        list.remove(1);
        System.out.println(list);
    }

}
