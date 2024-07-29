package train;

//题目描述：
//给定M(0<M<=30)个字符（a-z），从中取出任意字符（每个字符只能用一次）拼接成长度为N(0<N<=5)的字符串，
// 要求相同的字符不能相邻，计算出给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则返回0。
//
//输入描述
//给定的字符列表和结果字符串长度，中间使用空格(" ")拼接
//
//输出描述
//满足条件的字符串个数
//
//用例1
//输入
//aab 2
//输出
//2
//
//用例2
//abc 2
//输出
//6

import java.util.HashMap;
import java.util.Map;

public class Test3去重排列组合 {
    public static void main(String[] args) {
        String input1 = "aab 2";

        System.out.println(solution(input1));

//        String input2 = "abc 2";
//
//        System.out.println(solution(input2));
    }

    private static int solution(String input1) {
        String[] split = input1.split(" ");
        if (split.length != 2) {
            return 0;
        }

        String characters = split[0];
        int targetLength = Integer.parseInt(split[1]);
        if (targetLength <= 0 || targetLength > characters.length()) {
            return 0;
        }

        char[] charArray = characters.toCharArray();

        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (char c : charArray) {
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
        }

        return backtrack(characterCountMap, targetLength, ' ');
    }

    private static int backtrack(Map<Character, Integer> characterCountMap, int remainingLength, char prevChar) {
        if (remainingLength == 0)
            return 1;

        int sum = 0;

        // 遍历每个可用的字符
        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            char currentChar = entry.getKey();
            int frequency = entry.getValue();

            // 检查当前字符是否与前一个字符不同且数量大于0
            if (currentChar != prevChar && frequency > 0) {
                // 使用当前字符并减少其频率
                characterCountMap.put(currentChar, frequency - 1);

                // 继续递归剩余长度减一，并更新前一个字符为当前字符
                sum += backtrack(characterCountMap, remainingLength - 1, currentChar);

                // 回溯：恢复当前字符的频率
                characterCountMap.put(currentChar, frequency);
            }
        }

        return sum;
    }
}
