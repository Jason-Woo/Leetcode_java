import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    int targetColor;
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //init stack
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {sr, sc});

        targetColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        image[sr][sc] = newColor;

        //init hashSet
        Set<String> set = new HashSet<>(); // [1, 2] - > "1#2"

        //while loop check stack
        while(!list.isEmpty()){

            List<int[]> tmpList = new ArrayList<>();

            for (int[] curr : list) {
                //oop through ele in stack
                int currI = curr[0];
                int currJ = curr[1];

                if(currI > 0) {
                    //ceck up
                    if (!set.contains((currI - 1) + "#" + currJ))
                        if (image[currI - 1][currJ] == targetColor) {
                            image[currI - 1][currJ] = newColor;
                            tmpList.add(new int[]{currI - 1, currJ});
                            set.add((currI - 1) + "#" + currJ);
                        }
                }


                if(currI < m - 1) {
                    //check down
                    if (!set.contains((currI + 1) + "#" + currJ)) {
                        if (image[currI + 1][currJ] == targetColor) {
                            image[currI + 1][currJ] = newColor;
                            tmpList.add(new int[]{currI + 1, currJ});
                            set.add((currI + 1) + "#" + currJ);
                        }
                    }
                }

                if(currJ > 0) {
                    //check left
                    if (!set.contains(currI + "#" + (currJ - 1))) {
                        if (image[currI][currJ - 1] == targetColor) {
                            image[currI][currJ - 1] = newColor;
                            tmpList.add(new int[]{currI, currJ - 1});
                            set.add(currI + "#" + (currJ - 1));
                        }
                    }
                }

                if(currJ < n - 1) {
                    //check right
                    if (!set.contains(currI + "#" + (currJ + 1))) {
                        if (image[currI][currJ + 1] == targetColor) {
                            image[currI][currJ + 1] = newColor;
                            tmpList.add(new int[]{currI, currJ + 1});
                            set.add(currI + "#" + (currJ + 1));
                        }
                    }
                }
            }
            list.clear();
            list.addAll(tmpList);
        }
        return image;
    }
}