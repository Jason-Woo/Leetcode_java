import java.util.ArrayList;
import java.util.List;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            Car c = new Car(target - position[i], speed[i]);
            list.add(c);
        }
        list.sort((a, b) -> {return a.pos - b.pos;});

        int cnt = 1;
        double prevTime = list.get(0).time;

        boolean findGroup = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).time <= prevTime) {
                if (!findGroup) findGroup = true;
            } else {
                findGroup = false;
                cnt++;
            }
            prevTime = Math.max(prevTime, list.get(i).time);
        }
        return cnt;
    }
}

class Car {
    int pos;
    int speed;
    double time;

    public Car(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
        this.time = (double)pos / (double)speed;
    }
}