package com.atlihao.dataStructure.common;

/**
 * @author lihao
 * @ClassName Asserts
 * @Since 2020/2/12
 * @Description 断言测试工具
 */
public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) {
                throw new Exception("测试未通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
