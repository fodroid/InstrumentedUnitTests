package me.shihao.instrumentedunittests;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by shihao on 2017/3/2.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void test() {
        Espresso.onView(withId(R.id.editText)).perform(typeText("2"),closeSoftKeyboard());
        Espresso.onView(withId(R.id.editText2)).perform(typeText("5"),closeSoftKeyboard());
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.textView)).check(matches(withText("计算结果：6")));
        Espresso.onView(withId(R.id.textView)).check(matches(withText("计算结果：7")));
    }

    @Test
    public void testRecycleView() {
        Espresso.onView(withText("RecycleView")).perform(click());
        Espresso.onView(withText("Item 20")).check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.recycleview)).perform(RecyclerViewActions.scrollToPosition(21));
        Espresso.onView(withText("Item 20")).check(matches(isDisplayed()));
        Espresso.pressBack();
    }

    @Test
    public void testWebView() {
        Espresso.onView(withText("WebView")).perform(click());
        Espresso.pressBack();
    }

}