class MedianFinder {
    private PriorityQueue<Integer> small; 
    private PriorityQueue<Integer> large; 
    public MedianFinder() {
        small=new PriorityQueue<>(Collections.reverseOrder());
        large=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        if(!small.isEmpty() && !large.isEmpty() && small.peek()>large.peek())
        {
            int val=small.poll();
            large.offer(val);
        }
        if(!small.isEmpty()  && small.size()>(large.size()+1))
        {
            int val=small.poll();
            large.offer(val);
        }
        if(!large.isEmpty() && large.size()>small.size()+1)
        {
            int val=large.poll();
            small.offer(val);
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()) return small.peek();
        if(large.size()>small.size()) return large.peek();
        else return (small.peek()+large.peek())/2.0;
    }
}
