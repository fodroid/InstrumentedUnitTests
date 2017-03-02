package me.shihao.instrumentedunittests;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;


/**
 * Created by shihao on 2017/3/2.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void test() {
        Espresso.onView(withId(R.id.editText)).perform(typeText("2"));
        Espresso.onView(withId(R.id.editText2)).perform(typeText("5"));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withText("WebView")).perform(click());

    }

}