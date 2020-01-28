package com.example.listnotes.dashboard;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.listnotes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activtyRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void test_isActivityInView() {
        //ActivityScenario<MainActivity> activityActivityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_visibility_title_add_button(){
        onView(withId(R.id.add_item)).check(matches(isDisplayed()));
    }

    @Test
    public void test_nav_add_new_item_activity(){
        onView(withId(R.id.add_item)).perform(click());
        onView(withId(R.id.view_add_new_item)).check(matches(isDisplayed()));
    }
}