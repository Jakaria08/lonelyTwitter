package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

/////////////create EditTweetActivity//////////////////////////
// Use Relative layout and no back app compatibility and add a text view put text "New Activity"

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        //Go to lonelytwitter activity for list view click/////

        ///////////Excercise////////////

        /*Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        TextView displayField = (TextView) findViewById(R.id.textView);

        displayField.setText(message);*/
    }
}
