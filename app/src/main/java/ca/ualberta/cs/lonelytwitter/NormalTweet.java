package ca.ualberta.cs.lonelytwitter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
/**
 * Created by watts1 on 9/12/17.
 */

public class NormalTweet extends Tweet {

    public NormalTweet() {}

    public NormalTweet(String message) {
        super(message);
        FirebaseDatabase myDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = myDatabase.getReference();
        myRef.child("Tweets").setValue(this);
    }

    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }

}
