package com.example.listnotes.addNewItem;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.listnotes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ActAddNewItemTest {

    @Rule
    public ActivityScenarioRule<ActAddNewItem> activtyRule = new ActivityScenarioRule<ActAddNewItem>(ActAddNewItem.class);

    @Test
    public void test_isActivityInView() {
        onView(withId(R.id.view_add_new_item)).check(matches(isDisplayed()));
    }

    @Test
    public void test_isTitleTextDisplayed() {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(withText(R.string.label_add_new_item)));
    }

    @Test
    public void test_nav_add_new_item_activity(){
        onView(withId(R.id.save_content)).perform(click());
        //onView(withId(R.id.view_detail)).check(matches(isDisplayed()));
    }
}