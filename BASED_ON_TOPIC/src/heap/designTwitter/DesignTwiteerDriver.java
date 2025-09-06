package heap.designTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwiteerDriver {

  public static void main(String[] args) {


//    Twitter t = new Twitter();
//    t.postTweet(1,5);
//    System.out.println(t.getNewsFeed(1));
//    t.follow(1,2);
//    t.postTweet(2,6);
//    System.out.println(t.getNewsFeed(1));
//    t.unfollow(1,2);
//    System.out.println(t.getNewsFeed(1));

    Twitter t = new Twitter();
//    t.postTweet(1,1);
//    System.out.println(t.getNewsFeed(1));
    t.follow(1,5);
//    t.postTweet(2,6);
    System.out.println(t.getNewsFeed(1));
//    t.unfollow(1,2);
//    System.out.println(t.getNewsFeed(1));

  }
}

class Tweet{
  int tweetId;
   int incId;

  public Tweet(int tweetId, int incId) {
    this.tweetId = tweetId;
    this.incId = incId;
  }
}
class Twitter {

  Map<Integer,List<Tweet>> tweetmap = new HashMap<>();
  Map<Integer, Set<Integer>> followMap = new HashMap<>();

  int id =0;
  public Twitter() {


  }

  public void postTweet(int userId, int tweetId) {

    List<Tweet> tweetIdList = tweetmap.getOrDefault(userId,new ArrayList<>());
    tweetIdList.add(new Tweet(tweetId,id++));
    tweetmap.put(userId,tweetIdList);

  }

  public List<Integer> getNewsFeed(int userId) {

    PriorityQueue<Tweet> pq = new PriorityQueue<>((t1,t2)->Integer.compare(t2.incId,t1.incId));
    if(tweetmap.containsKey(userId)){
      pq.addAll(tweetmap.get(userId));
    }

    if(followMap.containsKey(userId)){
      for(Integer followId : followMap.get(userId)){
        if(tweetmap.containsKey(followId)){
          pq.addAll(tweetmap.get(followId));
        }
      }
    }


    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
      list.add(pq.poll().tweetId);
    }

return list;

  }

  public void follow(int followerId, int followeeId) {

    Set<Integer> followSet = followMap.getOrDefault(followerId,new HashSet<>());
    followSet.add(followeeId);
    followMap.put(followerId,followSet);

  }

  public void unfollow(int followerId, int followeeId) {
    Set<Integer> followSet = followMap.getOrDefault(followerId,new HashSet<>());
    followSet.remove(followeeId);
    followMap.put(followerId,followSet);
  }
}

