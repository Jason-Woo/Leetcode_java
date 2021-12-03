import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans = new ArrayList<>();

        int pointer1 = 0; //1
        int pointer2 = 0; //1

        int value = encoded1[0][0] * encoded2[0][0]; //value 3
        int valueNum = 0; //counter 0

        while (pointer1 < encoded1.length && pointer2 < encoded2.length) {
            int value1 = encoded1[pointer1][0]; // 1
            int valueNum1 = encoded1[pointer1][1]; //4

            int value2 = encoded2[pointer2][0]; //3
            int valueNum2 = encoded2[pointer2][1]; //1

            int tmp = value1 * value2; // number we get after multipy 3

            if (valueNum1 < valueNum2) {
                if (value != tmp) {
                    ans.add(Arrays.asList(value, valueNum));
                    value = tmp;
                    valueNum = valueNum1;
                } else {
                    valueNum += valueNum1;
                }
                encoded2[pointer2][1] -= encoded1[pointer1][1];
                pointer1++;
            } else if (valueNum1 > valueNum2) {
                if (value != tmp) {
                    ans.add(Arrays.asList(value, valueNum));
                    value = tmp;
                    valueNum = valueNum2;
                } else {
                    valueNum += valueNum2;
                }
                encoded1[pointer1][1] -= encoded2[pointer2][1];
                pointer2++;
            } else {
                if (value != tmp) {
                    ans.add(Arrays.asList(value, valueNum));
                    value = tmp;
                    valueNum = valueNum1;
                } else {
                    valueNum += valueNum1;
                }
                pointer1++;
                pointer2++;
            }
        }
        ans.add(Arrays.asList(value, valueNum));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRLEArray(new int[][]{{1, 4}, {5, 2}, {4, 4}}, new int[][]{{1, 4}, {5, 2}, {4, 4}}));
        System.out.println(new Solution().findRLEArray(new int[][]{{1, 3}, {2, 1}, {3, 2}}, new int[][]{{2, 3}, {3, 3}}));

    }
}
