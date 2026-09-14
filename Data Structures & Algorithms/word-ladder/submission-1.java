class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashMap<String,List<String>> map = new HashMap<>();
        Queue<String> q= new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        int res=1;
        wordList.add(beginWord);
        for(String s:wordList)
        {
            for(int i=0;i<s.length();i++)
            {
                StringBuilder sb= new StringBuilder(s);
                sb.setCharAt(i, '*');
                map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
            }
        }
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                String current=q.poll();
                for(int i=0;i<current.length();i++)
                {
                    StringBuilder sb= new StringBuilder(current);
                    sb.setCharAt(i, '*');
                    List<String> n=map.getOrDefault(sb.toString(),new ArrayList<>());
                    for(String s:n)
                    {
                        if(s.equals(endWord)) return res+1;
                        if(visited.add(s)) q.add(s);
                    }
                    map.remove(sb.toString());
                    
                }
                
            }
            res++;
        }
        return 0;
    }
}
