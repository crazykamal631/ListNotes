package com.example.listnotes.showItemDetail;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.listnotes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ActShowItemDetailTest {

    @Rule
    public ActivityScenarioRule<ActShowItemDetail> activtyRule = new ActivityScenarioRule<ActShowItemDetail>(ActShowItemDetail.class);

    @Test
    public void test_isActivityInView() {
        onView(withId(R.id.view_detail)).check(matches(isDisplayed()));
    }

}