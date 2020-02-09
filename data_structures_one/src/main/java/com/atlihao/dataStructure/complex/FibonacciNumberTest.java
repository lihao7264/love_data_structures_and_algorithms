package com.atlihao.dataStructure.complex;

import com.atlihao.dataStructure.common.TimeTool;

/**
 * @author lihao
 * @ClassName FibonacciNumberTest
 * @Since 2020/2/9
 * @Description 斐波那契数列的测试列子
 */
public class FibonacciNumberTest {
    /**
     * 斐波那契数列的例子：0 1 1 2 3 5 8 13 ...
     * 解法一：使用递归
     * 时间复杂度：O(2^n)
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }


    /**
     * 解法2:使用for循环计算
     * 位置：        0 1 2 3 4 5 6 7
     * 斐波那契数列：0 1 1 2 3 5 8 13 ...
     * 算法举例一：
     * a、如果n=2，则需要计算1次。
     * b、如果n=3，则需要计算2次。(也就是0+1、1+2)
     * c、总结：入参n，需要计算n-1次
     * 算法举例二：
     * a、如果n=3，则第一次计算位置0+位置1，并且赋值给位置2。(first就是位置0，second就是位置1)
     * 第二次计算位置1+位置2，并且赋值给位置3(也就是最终返回second的值)。(first就是位置1(也就是上次计算的second值)，second就是位置2(也就是上次计算的结果))
     * <p>
     * 时间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            //相加前两个值
            int sum = first + second;
            first = second;
            //上一次相加的结果，作为下次相加的second
            second = sum;
        }
        return second;
    }

    /**
     * 解法3:利用特征方程进行计算
     * 位置：        0 1 2 3 4 5 6 7
     * 斐波那契数列：0 1 1 2 3 5 8 13 ...
     * 时间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        //根号5
        double sqrt = Math.sqrt(5);
        //斐波那契的线性代数解法----特征方程
        return (int) ((Math.pow((1 + sqrt) / 2, n) - Math.pow((1 - sqrt) / 2, n)) / sqrt);
    }


    /**
     * 测试main方法
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(fib1(0));
//        System.out.println(fib1(1));
//        System.out.println(fib1(2));
//        System.out.println(fib1(3));
//        System.out.println(fib1(4));
//        System.out.println(fib1(5));

        //使用递归的，会出现性能的问题
//        System.out.println(fib1(64));

//        System.out.println(fib2(64));

        //测试两种解法的耗时情况
        int n = 46;
        TimeTool.test("fib1", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(n));
            }
        });
        TimeTool.test("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(n));
            }
        });

        TimeTool.test("fib3", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib3(n));
            }
        });
    }
}
