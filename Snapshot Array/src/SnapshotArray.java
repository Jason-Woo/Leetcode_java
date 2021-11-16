import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SnapshotArray {
    private List<HashMap<Integer, Integer>> memo;
    private int version = 0;
    private int len;

    public SnapshotArray(int length) {
        len = length;
        memo = new ArrayList<>();
        HashMap<Integer, Integer> currMemo = new HashMap<>();
        memo.add(currMemo);
    }

    public void set(int index, int val) {
        if (index >= len) {
            throw new IndexOutOfBoundsException();
        } else {
            memo.get(version).put(index, val);
        }
    }

    public int snap() {
        int currVersion = version;
        HashMap<Integer, Integer> currMemo = new HashMap<>(memo.get(currVersion));
        memo.add(currMemo);
        version++;
        return currVersion;
    }

    public int get(int index, int snap_id) {
        if (index >= len) {
            throw new IndexOutOfBoundsException();
        } else if (snap_id > version || snap_id < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return memo.get(snap_id).getOrDefault(index, 0);
        }
    }

    public static void main(String[] args) {
        SnapshotArray s = new SnapshotArray(4);
        s.set(0, 1);
        s.snap();
        s.set(0, 2);
        s.snap();
        System.out.println(s.get(0, 0));
        System.out.println(s.get(0, 2));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */