import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        Task[] extTasks = new Task[n];  //extTasks : exist Tasks

        for(int i = 0; i <n ; i++){
            Task nt = new Task(tasks[i][0],tasks[i][1],i);  //nt:new task
            extTasks[i] = nt;
        }
        Arrays.sort(extTasks, (a, b) -> {
            return a.startTime - b.startTime;
        });

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if(a.processTime == b.processTime) return a.index - b.index;
            return a.processTime - b.processTime;
        });

        int ai = 0;  //ai : answer index [will help to fill answer array]
        int ti = 0;  //ti : task index [ iterate over existing tasks,will help to know tasks pending]
        int currentTime = 0;

        while(ai < n){
            while(ti < n && extTasks[ti].startTime <= currentTime){
                pq.add(extTasks[ti++]);
            }

            if(pq.size() == 0){
                currentTime = extTasks[ti].startTime;
                continue;
            }

            Task bestFit = pq.remove();
            ans[ai++] = bestFit.index;
            currentTime += bestFit.processTime;
        }
        return ans;
    }

    public class Task{
        int startTime;
        int processTime;
        int index;

        Task(int startTime,int processTime,int index){
            this.startTime=startTime;
            this.processTime=processTime;
            this.index=index;
        }
    }
}