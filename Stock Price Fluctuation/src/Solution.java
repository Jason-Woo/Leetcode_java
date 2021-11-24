import java.util.Map;
import java.util.TreeMap;

class StockPrice {

    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Integer> map2;

    public StockPrice() {
        map = new TreeMap<>();
        map2 = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int valuePrev = map.get(timestamp);
            map2.put(valuePrev, map2.get(valuePrev) - 1);
            if (map2.get(valuePrev) <= 0) map2.remove(valuePrev);
        }
        map2.put(price, map2.getOrDefault(price, 0) + 1);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(map.lastKey());
    }

    public int maximum() {
        return map2.lastKey();
    }

    public int minimum() {
        return map2.firstKey();
    }
}
