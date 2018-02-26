package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.MyObserver;

public class TweetList implements MyObservable, MyObserver {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){

    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
        tweet.addObserver(this);
        notifyAllObservers();
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable) {
        //notifyAllObservers();
    }

}
