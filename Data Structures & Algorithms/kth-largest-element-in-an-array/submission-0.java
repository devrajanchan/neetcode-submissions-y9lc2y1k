class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kth=new PriorityQueue<>();
        for(int n:nums)
        {
            kth.offer(n);
            if(kth.size()>k) kth.poll();
        }
        return kth.peek();
    }
}
