class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l= temperatures.length;
        int[] res = new int[l];
        Stack<Integer> s= new Stack<>();
        s.push(0);
        for(int i =1;i<l;i++)
        {
            while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()])
            {
                int prevIndex = s.pop();
                res[prevIndex] = i - prevIndex;
            }
            s.push(i);
        }
        return res;
    }
}
