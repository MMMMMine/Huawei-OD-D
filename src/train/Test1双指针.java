package train;

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

public class Test1双指针 {

    public static void main(String[] args) {
        String s = "ace";
        String l = "abcde";

        int result = findSubStr(s, l);
        System.out.println(result);
    }

    private static int findSubStr(String s, String l) {
        int sIndex = 0;
        int lIndex = 0;

        while (lIndex < l.length()) {
            if (s.charAt(sIndex) == l.charAt(lIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return lIndex;
                }
            }
            lIndex++;
        }

        return -1;
    }
}
