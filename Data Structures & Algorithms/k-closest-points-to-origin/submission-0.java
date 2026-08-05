class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> close = new PriorityQueue<>(
            (a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])
        );
        for(int[] p:points)
        {
            close.offer(p);
            if(close.size()>k) close.poll();
        }
        int [][]result = new int[k][2];
        while(k>0)
        {
            result[--k]=close.poll();
        }
        return result;

    }
}
