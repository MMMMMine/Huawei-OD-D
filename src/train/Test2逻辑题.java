package train;

//题目描述：
//攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
//地图表示为一维数组，数组的索引代表水平位置，数组的高度代表相对海拔高度。其中数组元素0代表地面。
//例如[0,1,2,4,3,1,0,0,1,2,3,1,2,1,0], 代表如下图所示的地图，地图中有两个山脉位置分别为 1,2,3,4,5和8,9,10,11,12,13，最高峰高度分别为 4,3。最高峰位置分别为3,10。
//一个山脉可能有多座山峰(高度大于相邻位置的高度，或在地图边界且高度大于相邻的高度)。
//                4
//
//              +---+
//              |   |
//              |   | 3                       3
//              |   |
//              |   +---+                   -----
//              |       |                   |   |
//            2 |       |                 2 |   |     2
//              |       |                   |   |
//          +---+       |               ----+   |   +---+
//          |           |               |       |   |   |
//        1 |           | 1           1 |       | 1 |   | 1
//          |           |               |       |   |   |
//      +---+           +---+       +---+       +---+   +---+
//      |                   |       |                       |
//    0 |                   | 0   0 |                       | 0
//      |                   |       |                       |
//  +---+                   +-------+                       +---+
//
//    0   1   2   3   4   5   6   7   8   9  10  11  12  13  14
//
//输入描述
//输入一个整数数组，数组长度大于1
//
//输出描述
//输出地图中山峰的数量
//
//用例1
//输入
//0, 1, 2, 3, 2, 4
//输出2
//
//用例2
//输入0,1,4,3,1,0,0,1,2,3,1,2,1,0
//输出3
public class Test2逻辑题 {

    public static void main(String[] args) {
        int[] test1 = {0, 1, 2, 3, 2, 4};

        System.out.println(countPeaks(test1));

        int[] test2 = {0, 1, 4, 3, 1, 0, 0, 1, 2, 3, 1, 2, 1, 0};

        System.out.println(countPeaks(test2));
    }

    private static int countPeaks(int[] input) {
        int count = 0;

        if (input == null || input.length < 2)
            return count;

        if (input[0] > input[1]) {
            count++;
        }

        for (int i = 1; i < input.length - 1; i++) {
            if (input[i] > input[i - 1] && input[i] > input[i + 1]) {
                count++;
            }
        }

        if (input[input.length - 1] > input[input.length - 2]) {
            count++;
        }

        return count;
    }

}
