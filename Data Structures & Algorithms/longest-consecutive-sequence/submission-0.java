class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> Look= new HashSet<>();
        for(int n:nums){
            Look.add(n);
        }
        int longest =0;
        for(int n:nums){
            int length =1;
            if(!Look.contains(n-1)){
            int start=n;
            while(Look.contains(start+length))
            {
                length++;
            }
            } 
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
