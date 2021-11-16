import java.util.*;

class Solution {

    class MaxHeap {
        private Queue<Integer> queue;
        public MaxHeap() {
            queue = new PriorityQueue<>();
        }
        public void add(int num) {
            if (queue.size() < 4) {
                queue.add(num);
            } else if (num > queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }
        public List<Integer> get() {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            return list;
        }
    }

    class MinHeap {
        private Queue<Integer> queue;
        public MinHeap() {
            queue = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
        }
        public void add(int num) {
            if (queue.size() < 4) {
                queue.add(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }
        public List<Integer> get() {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            return list;
        }
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();
        for (int n : nums) {
            minHeap.add(n);
            maxHeap.add(n);
        }

        List<Integer> min = minHeap.get();
        List<Integer> max = maxHeap.get();
        int ans = max.get(3) - min.get(0);
        for (int i = 1; i < 4; i ++) {
            ans = Math.min(ans, max.get(3 - i) - min.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDifference(new int[]{6,6,0,1,1,4,6}));
    }
}