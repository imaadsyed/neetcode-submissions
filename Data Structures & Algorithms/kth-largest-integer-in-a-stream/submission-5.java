class KthLargest {
    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }

    private int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            
            while(j >= 0 && nums[j] < cur) {
                // shift smaller values to the right making room for cur
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }  
        
        return nums; 
    }
    
    public int add(int val) {
        int[] tmp = new int[nums.length + 1];
        int index = 0;
        tmp[index++] = val;
        for (; index < nums.length + 1; index++) {
            tmp[index] = nums[index - 1];
        }

        this.nums = sort(tmp);

        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return nums[k-1];
    }
}
