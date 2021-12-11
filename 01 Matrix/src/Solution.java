import java.util.LinkedList;
import java.util.Queue;

class Solution{

    //array for directions
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int[][] updateMatrix(int[][] input) {

        int m = input.length;
        int n = input[0].length;

        //int[][] ans;
        int[][]ans = new int[m][n];

        //Queue<int[]>
        Queue<int[]> queue = new LinkedList<>();

        //add all 0s to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        // int distance
        int currDistance = 0;

        //loop: queue is not empty
        while(!queue.isEmpty()) {
            currDistance++;
            // loop: check every ele in queue
            int currSize = queue.size();
            for (int cnt = 0; cnt < currSize; cnt++) {
                int[] pos = queue.poll();

                // loop: check for direction
                for (int i = 0; i < 4; i++) {
                    int currI = pos[0] + directions[i][0];
                    int currJ = pos[1] + directions[i][1];

                    // check if out of bound check if visit (ans[i][j] == 0 && input[i][j] != 0)
                    if (currI < 0 || currI >= m || currJ < 0 || currJ >= n || ans[currI][currJ] != 0 || input[currI][currJ] == 0) continue;

                    //update ans[i][j]
                    ans[currI][currJ] = currDistance;
                    //add into queue
                    queue.offer(new int[]{currI, currJ});
                }
            }
        }
        return ans;
    }

}