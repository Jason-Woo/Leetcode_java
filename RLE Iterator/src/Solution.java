class RLEIterator {

    private int[] cnt;
    private int[] ele;
    private int len;
    private int currIdx = 0;
    private int currShift = 0;

    public RLEIterator(int[] encoding) {
        len = encoding.length / 2;
        cnt = new int[len];
        ele = new int[len];
        for (int i = 0; i < len; i++) {
            if (encoding[2 * i] != 0) {
                cnt[i] = encoding[2 * i];
                ele[i] = encoding[2 * i + 1];
            }
        }
    }

    public int next(int n) {
        currShift += n;
//        System.out.println(currIdx + " " + currShift);
        if (currIdx >= len) return -1;
        while (currShift > cnt[currIdx]) {
            currShift -= cnt[currIdx];
            currIdx ++;
            if (currIdx >= len) return -1;
        }
        return ele[currIdx];
    }

    public static void main(String[] args) {
        RLEIterator r = new RLEIterator(new int[] {3,8,0,9,2,5});
        System.out.println(r.next(2));
        System.out.println(r.next(1));
        System.out.println(r.next(1));
        System.out.println(r.next(2));
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */