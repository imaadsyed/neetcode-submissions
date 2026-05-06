class Solution {
    /*
        variable size sliding window across string s
        max heap of caharacter frequency in s

        heap.pop() == k => return k // no swaps needed
        heap.pop() < k => return heap.pop() ()
        heap.pop() > k => not possible

        assume first of substring is max – add to heap 
        while(k >= 0) {
            if (next char != cur char)
                k--;
            r++
        }

        ABCDABCD k = 2
    */
    class CharFreq {
        public char ch;
        public int freq;

        CharFreq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        public void increment() {
            this.freq += 1;
        }
        public void decrement() {
            this.freq -= 1;
        }

        public int getFreq() {
            return this.freq;
        }
    }

    public int characterReplacement(String s, int k) {
        int maxDistinct = 0;
        Map<Character, CharFreq> freqIndex = new HashMap<>();
        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getFreq() - a.getFreq()
        );
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (!freqIndex.containsKey(s.charAt(r))) {
                CharFreq chFreq = new CharFreq(s.charAt(r), 0);
                freqIndex.put(s.charAt(r), chFreq);
                maxHeap.offer(chFreq);
            }
            maxHeap.remove(freqIndex.get(s.charAt(r)));
            freqIndex.get(s.charAt(r)).increment();
            maxHeap.offer(freqIndex.get(s.charAt(r)));

            // condition to update l – slide window
            while ((r - l + 1) - maxHeap.peek().freq > k) {
                maxHeap.remove(freqIndex.get(s.charAt(l)));
                freqIndex.get(s.charAt(l)).decrement();
                maxHeap.offer(freqIndex.get(s.charAt(l)));
                l++;
            }
            maxDistinct = Math.max(maxDistinct, r - l + 1);
        }

        return maxDistinct;
    }
}