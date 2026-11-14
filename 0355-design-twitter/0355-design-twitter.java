class Twitter {
    class Tweet {
        int tweetId, timestamp;
        public Tweet(int tweetId, int timestamp){
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    Map<Integer, List<Tweet>> userTweets;
    Map<Integer, Set<Integer>> userFollows;
    int timestamp;

    public Twitter() {
        this.timestamp = 0;
        userTweets = new HashMap<>();
        userFollows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));

        if(userTweets.containsKey(userId)){
            maxHeap.addAll(userTweets.get(userId));
        }

        if(userFollows.containsKey(userId)){
            for(int followeeId : userFollows.get(userId)){
                if(userTweets.containsKey(followeeId)){
                    maxHeap.addAll(userTweets.get(followeeId));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        
        while(!maxHeap.isEmpty() && count < 10){
            result.add(maxHeap.poll().tweetId);
            count += 1;
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollows.putIfAbsent(followerId, new HashSet<>());
        userFollows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userFollows.containsKey(followerId)){
            userFollows.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */