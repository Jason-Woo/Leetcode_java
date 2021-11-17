import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        //a[0]: id, a[1]: weight
        Queue<int[]> free = new PriorityQueue<>((a, b) -> a[1] == b[1] ? (a[0] - b[0]) : (a[1] - b[1]));
        //b[0]: id, b[1]: ending time
        Queue<int[]> busy = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int ans[] = new int[tasks.length];

        for(int i = 0; i < servers.length; i++) {
            free.add(new int[]{i, servers[i]});
        }

        int curTime = 0;
        int i = 0;
        while(i < tasks.length) {
            //free up servers that have comleted tasks till curTime
            while(!busy.isEmpty() && busy.peek()[1] <= curTime) {
                int id = busy.poll()[0];
                free.add(new int[]{id, servers[id]});
            }
            // allocate all pending tasks until free servers are available
            while(i < tasks.length && i <= curTime && !free.isEmpty()) {
                int id = free.poll()[0];
                busy.add(new int[]{id, curTime + tasks[i]});
                ans[i++] = id;
            }
            // is no free servers available, wait until a server becomes free
            // else move to next task
            if(free.isEmpty()) {
                curTime = busy.peek()[1];
            } else {
                curTime++;
            }

        }

        return ans;
    }
}