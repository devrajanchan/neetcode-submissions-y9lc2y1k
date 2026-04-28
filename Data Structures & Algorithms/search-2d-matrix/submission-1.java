class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        System.out.println(c);
        int l=0;
        int h=r*c-1;
        while(l<=h )
        {
            int m=l+(h-l)/2;
            int midVal = matrix[m/c][m%c];
            if(midVal==target) return true;
            else if(midVal<target)
            {
                l=m+1;
            }
            else if(midVal>target)
            {
                h=m-1;
            }
        }
        return false;
    }
}
