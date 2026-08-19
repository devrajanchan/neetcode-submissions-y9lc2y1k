class Twitter {
HashMap<Integer,HashSet<Integer>> followMap;
int counter;
Map<Integer, List<int[]>> tweetMap;
    public Twitter() {
        followMap=new HashMap<>();
        tweetMap=new HashMap<>();
        counter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{counter++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result= new ArrayList<>();
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<Integer> users = new HashSet<>();
        if(followMap.containsKey(userId))
        {
            users.addAll(followMap.get(userId));
        }
        users.add(userId);
        for(int followeeId:users)
        {
            if(tweetMap.containsKey(followeeId))
            {
                List<int[]> tweets =tweetMap.get(followeeId);
                int lastIndex=tweets.size()-1;
                int[] tweet=tweets.get(lastIndex);
                maxHeap.add(new int[]{tweet[0],tweet[1],followeeId,lastIndex});
            }
        }
        while (!maxHeap.isEmpty() && result.size() < 10) {
        int[] top = maxHeap.poll();
        int tweetId = top[1];
        int followeeId = top[2];
        int index = top[3];

        result.add(tweetId);

      
        if (index > 0) {
            int[] nextTweet = tweetMap.get(followeeId).get(index - 1);
            maxHeap.add(new int[]{nextTweet[0], nextTweet[1], followeeId, index - 1});
        }
    }

    return result;

    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
        {
     followMap.get(followerId).remove(followeeId);
        }
    }
}
