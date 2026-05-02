class KthLargest {
    private List<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        heap = new ArrayList<>();
        // heap only starts at index 1 = root
        heap.add(-1);
        // construct the heap
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            
        }
        System.out.println("Done init");

    }
    
    public int add(int val) {
        int i = heap.size();
        heap.add(val);

        // percolate upwards
        while(i > 0) {
            // round down
            int parentIndex = i / 2;
            if (parentIndex == 0) {
                break;
            }

            if (heap.get(parentIndex) > val) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, val);
                heap.set(i, temp);
            }
            i = parentIndex;
        }

        System.out.println("Added: " + heap.toString());
        List<Integer> heapCopy = new ArrayList<>(heap);
        int kthLargest = -1;
        for (int j = 0; j < heap.size() - k; j++) {
            kthLargest = pop(heapCopy);
        }
        System.out.println("Post pop: " + heapCopy.toString());
        System.out.println();
        return kthLargest;
    }

    private int pop(List<Integer> heap) {
        if (heap.size() < 2) {
            return -1;
        }

        int min = heap.get(1);
        int last = heap.get(heap.size() - 1);

        heap.set(1, last);
        heap.remove(heap.size() - 1);

        int i = 1;

        while (true) {
            int left = i * 2;
            int right = i * 2 + 1;
            int smallest = i;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);

            i = smallest;
        }

        return min;
    }
}
