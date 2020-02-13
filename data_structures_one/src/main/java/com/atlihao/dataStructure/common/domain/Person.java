package com.atlihao.dataStructure.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

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
}
