import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0) stack.push(asteroids[i]);
            else {
                boolean done = false;
                if (stack.empty()){
                    stack.push(asteroids[i]);
                    continue;
                }
                while (! done && stack.peek() > 0) {
                    if (stack.peek() > Math.abs(asteroids[i])) {
                        done = true;
                    } else if (stack.peek() == Math.abs(asteroids[i])) {
                        stack.pop();
                        done = true;
                    } else {
                        stack.pop();
                    }
                    if (stack.empty()) break;
                }
                if (! done) stack.push(asteroids[i]);
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{1, -1, -2, -2})));
    }
}