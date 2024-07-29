package answer;

//题目描述：字符串序列判定/最后一个有效字符
//输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。判定S是否是L的有效子串。
//判定规则：
//S中的每个字符在L中都能找到（可以不连续），且S在Ｌ中字符的前后顺序与S中顺序要保持一致。
//（例如，S="ace"是L="abcde"的一个子序列且有效字符是a、c、e，而”aec”不是有效子序列，且有效字符只有a、e）
//输入描述
//输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。
//先输入S，再输入L，每个字符串占一行。
//输出描述
//输出S串最后一个有效字符在L中的位置。（首位从0开始计算，无有效字符返回-1）



//为了解决这个问题，我们可以使用双指针技术。一个指针用于遍历字符串S，另一个指针用于遍历字符串L。我们从左到右依次检查S中的每个字符是否按顺序出现在L中。
//
//以下是具体步骤：

//初始化两个指针：sIndex 为0，表示当前正在S中查找的字符的索引；lIndex 也为0，表示当前在L中搜索的位置。
//遍历字符串L：对于L中的每个字符，如果它与S中sIndex位置的字符相同，则将sIndex加1。
//如果sIndex等于S的长度，则说明已经找到了所有S中的字符，并且它们在L中保持了正确的顺序。此时，lIndex - 1就是最后一个有效字符在L中的位置。
//如果遍历完整个L后sIndex不等于S的长度，则说明没有找到匹配的子串，返回-1。

public class Solution1 {
    public static void main(String[] args) {
        // 测试用例1
        String S1 = "ace";
        String L1 = "abcde";

        // 调用方法并打印结果
        int result1 = findLastValidCharPosition(S1, L1);
        System.out.println(result1);

        //测试用例2
        String S2 = "fgh";
        String L2 = "abcde";

        // 调用方法并打印结果
        int result2 = findLastValidCharPosition(S2, L2);
        System.out.println(result2);
    }

    public static int findLastValidCharPosition(String S, String L) {
        int sIndex = 0;
        int lIndex = 0;

        while (lIndex < L.length()) {
            if (S.charAt(sIndex) == L.charAt(lIndex)) {
                sIndex++;
                if (sIndex == S.length()) {
                    return lIndex; // 找到最后一个有效字符
                }
            }
            lIndex++;
        }

        return -1; // 没有找到有效子串
    }

}
