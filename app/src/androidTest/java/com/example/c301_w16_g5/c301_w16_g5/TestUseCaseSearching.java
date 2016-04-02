package com.example.c301_w16_g5.c301_w16_g5;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.SearchView;

import com.robotium.solo.Solo;

import java.util.ArrayList;

/**
 * Created by Hailey on 2016-03-31.
 */
public class TestUseCaseSearching extends ActivityInstrumentationTestCase2 {

    private Solo solo;
    private String username = "hailey123";  // must be a user with at least 1 chicken

    public TestUseCaseSearching() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        //setUp() is run before a test case is started.
        //This is where the solo object is created.
        solo = new Solo(getInstrumentation());
        getActivity();

        // enter the app
        solo.unlockScreen();
        solo.enterText((AutoCompleteTextView) solo.getView(R.id.usernameEntered), username);
        solo.clickOnView(solo.getView(R.id.signInButton));
        solo.assertCurrentActivity("Expected Home Activity", HomeActivity.class);
    }

    @Override
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }

    public void testKeywordSearch() {
        // the back-end
        // Is this already tested somewhere else?
    }

    public void testViewSearchResults() {
        // the front-end

        // expected result:
        ArrayList<Chicken> result = ChickBidsApplication.getSearchController().searchByKeyword("bob");

        // go to search screen
        solo.clickOnView(solo.getView(R.id.buttonSearch));
        solo.assertCurrentActivity("Expected Search Activity", SearchesActivity.class);

        // perform a search
        solo.clickOnMenuItem("Search");
        solo.assertCurrentActivity("Expected Search Activity", SearchesActivity.class);

        // TODO: figure out how to input the text

        solo.sendKey(Solo.ENTER);

        // TODO: compare expected result and list displayed
    }
}