class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digitToLetters = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
};
    List<String> res = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
    return res;
}
    backtrack(res,digitToLetters,new StringBuilder(),digits,0);
    
    return res;
    }
    private void backtrack(List<String> res,String[] digitToLetters,StringBuilder sub,String digits,int i)
    {
        
        if(i==digits.length())
        {
            res.add(sub.toString());
            return;
        }
        char digit=digits.charAt(i);
        String letters=digitToLetters[digit-'0'];
        for(int j=0;j<letters.length();j++)
        {
            sub.append(letters.charAt(j));
            backtrack(res,digitToLetters,sub,digits,i+1);
            sub.deleteCharAt(sub.length()-1);
        }
    }
}
