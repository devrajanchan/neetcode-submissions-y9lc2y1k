class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=numbers.length;
        int i=0;
        int j=l-1;
        int [] res= new int[2];
        while(i<j)
        {
            if(numbers[i]+numbers[j]==target)
            {
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
            else if(numbers[i]+numbers[j]<target)
            {
                i++;
            }
            else if(numbers[i]+numbers[j]>target)
            {
                j--;
            }
        }
        return res;
    }
}
