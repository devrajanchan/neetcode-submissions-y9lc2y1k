class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> result = new HashMap<>();
        for(String s:strs)
        {
            char[] sortedCharArr=s.toCharArray();
            Arrays.sort(sortedCharArr);
            String sortedString=new String(sortedCharArr);
            result.computeIfAbsent(sortedString,k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(result.values());
    }
}
