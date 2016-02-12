package com.example.c301_w16_g5.c301_w16_g5;

import android.test.ActivityInstrumentationTestCase2;

public class ChickenTest extends ActivityInstrumentationTestCase2 {

    public ChickenTest() {
        super(MainScreen.class);
    }

    Chicken chicken;
    User user;

    protected void setUp() throws Exception{
        super.setUp();

        user = new User();
        chicken = new Chicken("Bob", "Friendly chicken", 13.55, Chicken.Status.AVAILABLE);
        user.removeAllChickens();
    }

    public void testAddAThing() {
        user.addChicken(chicken);
        assertFalse(user.getNumberOfThings() == 0);
    }

    public void testEditMyThing() {
        user.addChicken(chicken);
        assertFalse(user.getNumberOfThings() == 0);

        Chicken chicken = user.getChicken(0);
        chicken.update("Tim", "No chicken", 15.99, Chicken.Status.AVAILABLE);

        assertEquals(chicken.getName(), "Tim");
        assertEquals(chicken.getDescription(), "No chicken");
    }

    public void testDeleteMyThing() {
        user.addChicken(chicken);
        assertFalse(user.getNumberOfThings() == 0);

        user.deleteChicken(chicken);
        assertEquals(user.getNumberOfThings(), 0);
    }

    public void testThingHasStatus() {
        user.addChicken(chicken);
        assertFalse(user.getNumberOfThings() == 0);

        assertFalse(chicken.getStatus() == Chicken.Status.AVAILABLE);
    }
}