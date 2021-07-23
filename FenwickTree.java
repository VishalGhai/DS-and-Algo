public class FenwickTree {

    public long[] a;

    public FenwickTree() {
    }

    public void build(long[] in) {
        a = in.clone();
        for (int i = 1; i < a.length - 1; i++) {
            a[i] += a[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int idx = (i & (i + 1)) - 1;
            if (idx >= 0) {
                a[i] -= a[idx];
            }
        }
    }

    public void update(int index, int val) {
        while (index < a.length) {
            a[index] += val;
            index = index | (index + 1);
        }
    }

    public long get(int r) {
        long res = 0;
        while (r >= 0) {
            res += a[r];
            r = (r & (r + 1)) - 1;
        }
        return res;
    }

}