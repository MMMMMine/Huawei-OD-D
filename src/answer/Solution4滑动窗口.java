package answer;

//题目描述：
//一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
//
//输入描述
//一个目标整数T (1 <=T<= 1000)
//
//输出描述
//该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
//自然数个数最少的表达式优先输出
//每个表达式中按自然数递增的顺序输出，具体的格式参见样例。
//在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
//
//用例1
//输入
//9
//输出
//9=9
//9=4+5
//9=2+3+4
//Result:3
//
//用例2
//10
//输出
//10=10
//10=1+2+3+4
//Result:2

public class Solution4滑动窗口 {
    public static void main(String[] args) {
        // 用例1
        int target1 = 9; // 示例输入
        findContinuousSequences(target1);
        // 用例2
        int target2 = 10; // 示例输入
        findContinuousSequences(target2);

    }

    public static void findContinuousSequences(int target) {
        int count = 0;

        // 输出格式化字符串
        for (int length = 1; length * (length + 1) / 2 <= target; length++) {
            // 根据等差数列求和公式(length * (start + end)) / 2 = target计算起始值start
            float startFloat = ((float) (2 * target) / length - length + 1) / 2;
            if (startFloat == (int) startFloat) { // 如果start是整数，则找到一个有效序列
                printSequence((int) startFloat, (int) startFloat + length - 1, target); // 打印序列
                count++; // 序列计数增加
            }
        }

        System.out.println("Result:" + count);
    }

    private static void printSequence(int start, int end, int target) {
        System.out.print(target + "=");
        for (int i = start; i <= end; i++) {
            System.out.print(i == start ? "" : "+");
            System.out.print(i);
        }
        System.out.println();
    }
}

//为了解决这个问题，我们可以使用一个滑动窗口的方法来找到所有可能的连续自然数序列，其和等于给定的整数T。下面是解题思路：
//-

//初始化两个指针start和end，分别代表当前考虑的连续自然数序列的起始和结束位置，初始都设置为1。
//初始化一个变量sum来记录当前序列之和，初始值设为0。
//当start小于等于T/2时（因为当start大于T/2时，不可能有长度超过1的连续自然数序列其和仍然等于T），执行以下步骤：
//a. 如果当前sum小于T，则将end加一，并将新的end值加到sum上。
//b. 如果当前sum大于T，则从sum中减去start，并将start加一。
//c. 如果当前sum等于T，则找到了一个有效的连续自然数序列。打印出该序列，并将start加一，更新sum。
//记录并打印出找到的有效序列总数。