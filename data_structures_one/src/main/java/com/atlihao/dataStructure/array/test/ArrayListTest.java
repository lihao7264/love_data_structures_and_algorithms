package com.atlihao.dataStructure.array.test;

import com.atlihao.dataStructure.array.ArrayList;
import com.atlihao.dataStructure.common.domain.Person;

/**
 * @author lihao
 * @ClassName ArrayListTest
 * @Since 2020/2/9
 * @Description 动态数组类的测试类
 */
public class ArrayListTest {

    //1、测试数据
//    public static void main(String[] args) {
//        //所有的类，最终都继承java.lang.Object
//        //new是向堆空间申请内存
////        ArrayList<Integer> list = new ArrayList<>();
////        list.add(99);
////        list.add(88);
////        list.add(77);
////        list.add(66);
////        list.add(55);
//
////        list.remove(2);
////        list.add(1, 100);
////        list.add(list.size(), 100);
////        Asserts.test(list.get(1) == 100);
////        System.out.println(list);
//
//   }

    /**
     * 测试数据2---泛型之后的(clear、remove方法优化)
     *
     * @param args
     */
//    public static void main(String[] args) {
//        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(new Person(10, "Jack"));
//        persons.add(null);
//        persons.add(new Person(12, "James"));
//        persons.add(null);
//        persons.add(new Person(15, "Rose"));
//        persons.clear();
//        //提醒JVM进行垃圾回收
//        System.gc();
//    }

    /**
     * 测试数据3---null值处理
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "Jack"));
        persons.add(null);
        persons.add(new Person(12, "James"));
        persons.add(null);
        persons.add(new Person(15, "Rose"));
        System.out.println(persons);
        System.out.println(persons.indexOf(null));
    }
}
