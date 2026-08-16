class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq= new int[26];
        int maxFreq=0;
        for(int task:tasks)
        {
            freq[task-'A']++;
            maxFreq=Math.max(maxFreq,freq[task-'A']);
        }
        int maxFreqC=0;
        for(int i:freq)
        {
            if(i==maxFreq) maxFreqC++;
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+maxFreqC);
    }
}
