import java.io.*;

class Twitter {
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Integer[]>> tweetMap;
    private Integer tweetCount;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        tweetCount = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Integer[]{tweetId, tweetCount});
        tweetCount++;
    }

    public List<Integer> getNewsFeed(int userId) {
        // based on 'merge k sorted lists'
        List<Integer> feed = new ArrayList<>();
        //if (!followMap.containsKey(userId)) return feed;

        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0])); // [] -> [tweetCount, tweetId, followeeId, nextIndex]

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (Integer followeeId: followMap.get(userId)) {
            // get the recent post add it to maxHeap
            if (tweetMap.containsKey(followeeId)) { // only if tweetmap contains tweet by followeeId
                int index = tweetMap.get(followeeId).size()-1; // we need index because we can add it to maxheap to parse the same list as we poll
                Integer[] tweet = tweetMap.get(followeeId).get(index);
                maxHeap.add(new Integer[]{tweet[1], tweet[0], followeeId, index-1});
            }
        }
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Integer[] tweet = maxHeap.poll();
            feed.add(tweet[1]);
            if (tweet[3] >= 0) { // if valid index
                Integer[] nextTweet = tweetMap.get(tweet[2]).get(tweet[3]);
                maxHeap.add(new Integer[]{nextTweet[1], nextTweet[0], tweet[2], tweet[3]-1});
            }
        }

        return feed;

    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
