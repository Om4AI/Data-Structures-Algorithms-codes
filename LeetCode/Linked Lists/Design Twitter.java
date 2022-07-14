import java.util.*;
class Tweet{
    int uid;
    int tid;
    int time;
    Tweet(int user, int tweet, int time){
        uid = user;
        tid = tweet;
        this.time = time;
    }
}

class Twitter {
    public static int time = 0;
    public static HashMap<Integer, List<Integer>> users;
    public static HashMap<Integer, List<Tweet>> feeds;
    public Twitter(){
        users = new HashMap<>();
        feeds = new HashMap<>();
    }
    
    // --------- Function 1 ----------
    public void postTweet(int userId, int tweetId){
        Tweet t = new Tweet(userId,tweetId,time);
        time+=1;

        // Add the tweet to feeds of all followers of userId
        if(!users.containsKey(userId)){
            List<Integer> l = new ArrayList<>();
            l.add(userId);
            users.put(userId,l);
        }

        List<Integer> followers = users.get(userId);
        for(int u: followers){
            if(feeds.containsKey(u)){
                List<Tweet> feed = feeds.get(u);
                feed.add(0, t);
                feeds.put(u,feed);
            }else{
                List<Tweet> feed = new ArrayList<>();
                feed.add(t);
                feeds.put(u,feed);
            }
        }
    }
    
    // --------- Function 2 ----------
    public List<Integer> getNewsFeed(int userId){
        if(!feeds.containsKey(userId)) return new ArrayList<>();
        
        List<Tweet> feed = feeds.get(userId);
        Collections.sort(feed, (a,b)->(b.time-a.time));
        List<Integer> res = new ArrayList<>();
        for(Tweet t: feed){
            if(!res.contains(t.tid)) res.add(t.tid);
            if(res.size()==10) return res;
        }
        return res;
    }
    
    // --------- Function 3 ----------
    public void follow(int fan, int star) {
        if(users.containsKey(star)){
            List<Integer> l = users.get(star);
            l.add(fan);
            users.put(star,l);
        }else{
            List<Integer> l = new ArrayList<>();
            l.add(star);
            l.add(fan);
            users.put(star,l);
        }


        // Add the tweets of star to fan's feed
        if(feeds.containsKey(star)){
            List<Tweet> feed = feeds.get(star);
            List<Tweet> startweets = new ArrayList<>();
            for(Tweet t: feed){
                if(t.uid==star) startweets.add(t);
            }

            if(feeds.containsKey(fan)){
                List<Tweet> ffeed = feeds.get(fan);
                ffeed.addAll(startweets);
                feeds.put(fan,ffeed);
            }else{
                feeds.put(fan,startweets);
            }
        }
    }
    
    // --------- Function 4 ----------
    public void unfollow(int fan, int star) {
        if(!users.containsKey(star) || users.get(star).indexOf(fan)==-1) return;
        List<Integer> l = users.get(star);
        l.remove(l.indexOf(fan));
        users.put(star,l);

        // Delete the tweets posted by star from the fan's feed
        if(feeds.containsKey(fan)){
            List<Tweet> feed = feeds.get(fan);
            List<Tweet> newFeed = new ArrayList<>();

            // Create new Feed without the tweets of the star
            for(int i=0; i<feed.size(); i++){
                Tweet tweet = feed.get(i);
                if(tweet.uid!=star){
                    newFeed.add(tweet);
                }
            }
            feeds.put(fan,newFeed);
        }
    }
}