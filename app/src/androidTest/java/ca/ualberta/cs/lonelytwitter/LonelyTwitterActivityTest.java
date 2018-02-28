package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;


import com.robotium.solo.Solo; // Add robotium dependency

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo; //Dont forget this! private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    //Make setup function (talk about setUp and tearDown, they run before and after every test

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
        //Might need a call to super.setUp() if this doesnt work;
    }

    // teardown in the bottom

    //there is also (in Junit4?)
	//import org.junit.AfterClass;
	//import org.junit.BeforeClass;
   //@BeforeClass
    //@AfterClass
    // Which will only run before and after all of the tests

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet()
    {

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");

        solo.clickOnButton("Save");

    // Show without clearing edit text and then clearing edit text

        solo.clearEditText((EditText) solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test Tweet!"));

        // Implement clear button

        solo.clickOnButton("Clear");

        assertFalse(solo.waitForText("Test Tweet!",1,3000));

    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity();

        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet!"); //Sometimes you have to wait for the screen to update

        ///create getOldTweetsList() function : go lonelytwitter activity///////////////////////

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong Activity", EditTweetActivity.class);

        //Add a textView that says New Activity
        assertTrue(solo.waitForText("New Activity"));


        solo.goBack();
        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);

        /////////////create EditTweetActivity//////////////////////////
    }

    ////////////////////////////Excercise///////////////////////////////////////
/*
    public void testEditTweetActivity() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Tweet test");
        solo.clickOnButton("Save");
        solo.waitForText("Tweet test");

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);

        assertEquals("Tweet test", tweet.getMessage());


        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong activity", EditTweetActivity.class);
        assertTrue(solo.searchText("Tweet test"));

        solo.goBack();
        solo.assertCurrentActivity("Wrong activity", LonelyTwitterActivity.class);
    }*/

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}