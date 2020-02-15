package com.atlihao.dataStructure.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

/**
 * @author lihao
 * @ClassName Person
 * @Since 2020/2/13
 * @Description 测试辅助类
 */
@Data
@AllArgsConstructor
@ToString
public class Person {

    private int age;

    private String name;

    /**
     * 对象销毁时,要调用的方法
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person - finalize");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age;
    }
}
