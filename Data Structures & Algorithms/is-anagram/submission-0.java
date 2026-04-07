class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();
        for(char c:s.toCharArray())
        {
            a.put(c, a.getOrDefault(c, 0) + 1);
        }
        for(char d:t.toCharArray())
        {
            b.put(d, b.getOrDefault(d, 0) + 1);
        }
        boolean ana=false;
        if(a.equals(b))
        {
            ana=true;
        }

        return ana;
    }
}
