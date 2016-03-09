package com.example.c301_w16_g5.c301_w16_g5;

import android.test.ViewAsserts;

/**
 * UI test for the app's Home screen.
 *
 * @author  Hailey
 * @version 1.4, 03/07/2016
 * @see     HomeActivity
 */
public class HomeActivityUITest extends ToolbarActivityUITest {

    public HomeActivityUITest() {
        super(HomeActivity.class);
    }

    public void testButtonsVisible() {
        ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),
                activity.findViewById(R.id.buttonProfile));

        ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),
                activity.findViewById(R.id.buttonChickens));

        ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),
                activity.findViewById(R.id.buttonSearch));
    }
}