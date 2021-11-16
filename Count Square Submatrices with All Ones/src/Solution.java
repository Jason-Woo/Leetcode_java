//[0,1,1,1]
//[1,1,1,1]
//[0,1,1,1]

//[0,1,1,1]
//[1,1,2,2]
//[0,1,2,3]

import java.util.Arrays;

class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                res += matrix[i][j];
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
    }
}