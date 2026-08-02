class KthLargest {
    private int k;
    private int [] nums;
    PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;
        for(int n:nums)
        {
            minHeap.offer(n);
            if(minHeap.size()>k) minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k) minHeap.poll();
        return minHeap.peek();
    }
}
