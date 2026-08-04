class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> boom = new PriorityQueue<>(Collections.reverseOrder());
        for( int s:stones)
        {
            boom.offer(s);
        }
        while(boom.size()>1)
        {
            int x=boom.poll();
            int y=boom.poll();
            if(x-y!=0) boom.offer(x-y);
        }
        if(!boom.isEmpty()) return boom.peek();
        return 0;
    }
}
