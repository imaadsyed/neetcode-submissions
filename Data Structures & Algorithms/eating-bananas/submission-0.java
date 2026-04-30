class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > r) {
                r = piles[i];
            }
        }
        int res = r;

        while (l <= r) {
            int k = l + (r - l) / 2;
            // if (k == 0) {
            //     l = 1;
            //     continue;
            // }
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (long) Math.ceil((double)piles[i] / k);
            }

            if (hours <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}