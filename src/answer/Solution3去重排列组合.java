package answer;

//题目描述：
//给定M(0<M<=30)个字符（a-z），从中取出任意字符（每个字符只能用一次）拼接成长度为N(0<N<=5)的字符串，要求相同的字符不能相邻，计算出给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则返回0。
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

public class Solution3去重排列组合 {
    private static int countValidCombinations(String input1) {
        String[] parts = input1.split(" ");
        if (parts.length != 2) {
            return 0;
        }

        String characters = parts[0];
        int targetLength = Integer.parseInt(parts[1]);
        if (targetLength <= 0 || targetLength > characters.length()) {
            return 0;
        }

        char[] chars = characters.toCharArray();
        // 用于记录每个字符出现的次数
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : chars) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        return backtrack(charFrequency, targetLength, ' ');
    }

    private static int backtrack(Map<Character, Integer> charFrequency, int remainingLength, char prevChar) {
        // 如果达到目标长度，返回1表示找到一种有效组合
        if (remainingLength == 0)
            return 1;

        int sum = 0;

        // 遍历每个可用的字符
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            char currentChar = entry.getKey();
            int frequency = entry.getValue();

            // 检查当前字符是否与前一个字符不同且数量大于0
            if (currentChar != prevChar && frequency > 0) {
                // 使用当前字符并减少其频率
                charFrequency.put(currentChar, frequency - 1);

                // 继续递归剩余长度减一，并更新前一个字符为当前字符
                sum += backtrack(charFrequency, remainingLength - 1, currentChar);

                // 回溯：恢复当前字符的频率
                charFrequency.put(currentChar, frequency);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        //用例1
        String input1 = "aab 2";
        int result1 = countValidCombinations(input1);
        System.out.println(result1);

        //用例2
        String input2 = "abc 2";
        int result2 = countValidCombinations(input2);
        System.out.println(result2);
    }
}


//为了解决这个问题，我们可以使用回溯算法来生成所有可能的字符串组合，并在过程中检查是否满足条件（相同字符不相邻）。下面是一个简单的步骤说明：
//
//解析输入字符串，分离字符列表和目标长度N。
//使用回溯算法生成所有可能的字符串组合。
//在生成每个字符时，检查它是否与前一个字符相同。如果是，则跳过该字符。
//如果当前生成的字符串长度达到N，则将其计数。
//最后返回计数值。
