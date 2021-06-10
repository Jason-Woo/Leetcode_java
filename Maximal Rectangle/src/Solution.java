class Solution {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height <= 0) {
            return 0;
        }
        int width = matrix[0].length;
        int[][] newMatrix = new int[height][width];

        int max_area = 0;
        for (int i = 0; i < height; i++) {
            if (i == 0) {
                for (int j = 0; j < width; j++) {
                    if (matrix[0][j] == '0') {
                        newMatrix[0][j] = 0;
                    } else {
                        newMatrix[0][j] = 1;
                    }
                }
            } else {
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] == '0') {
                        newMatrix[i][j] = 0;
                    } else {
                        newMatrix[i][j] = newMatrix[i - 1][j] + 1;
                    }
                }
            }

            for (int j = 0; j < width; j ++) {
                int min = newMatrix[i][j];
                for (int k = j; k >= 0; k--) {
                    min = Math.min(min, newMatrix[i][k]);
                    max_area = Math.max(max_area, min * (j - k + 1));
                }
            }
        }
        return max_area;
    }
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        char[][] matrix2 = {{'1'}};
        char[][] matrix3 = {{'0', '0', '1'}, {'1', '1', '1'}};
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(matrix));
        System.out.println(s.maximalRectangle(matrix2));
        System.out.println(s.maximalRectangle(matrix3));
    }
}