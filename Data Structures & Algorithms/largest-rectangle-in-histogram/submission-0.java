class Solution {
    public int largestRectangleArea(int[] heights) {
        int l= heights.length;
        int maxArea=0;
        Stack<int[]> s = new Stack<>();
        for(int i=0;i<l;i++)
        {
            int start =i;
            while(!s.isEmpty() && s.peek()[1]>heights[i])
            {
                int[] top=s.pop();
                int index=top[0];
                int height=top[1];
                maxArea=Math.max(maxArea,height*(i-index));
                start=index;
            }
            s.push(new int[]{start, heights[i]});
        }
        for(int[] p:s)
        {
            maxArea=Math.max(maxArea,(p[1]*(l-p[0])));
        }
        return maxArea;
    }
}
