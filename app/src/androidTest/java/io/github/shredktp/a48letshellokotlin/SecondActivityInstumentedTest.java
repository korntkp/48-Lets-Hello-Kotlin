package io.github.shredktp.a48letshellokotlin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

/**
 * Created by Korshreddern on 21-Feb-17.
 */

@RunWith(AndroidJUnit4.class)
public class SecondActivityInstumentedTest {

    Context appContext;

    @Before
    public void setup() {
        appContext = InstrumentationRegistry.getTargetContext();
        onView(withId(R.id.btn_goto_second)).perform(click());
    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        public MainActivity getActivity() {
            return super.getActivity();
        }
    };

    @Test
    public void useAppContext() throws Exception {
        assertEquals("io.github.shredktp.a48letshellokotlin", appContext.getPackageName());
    }

    @Test
    public void checkViewInSecondActivity() {
        onView(withId(R.id.tv_title_second)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_goto_third_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_show_toast)).check(matches(isDisplayed()));

        onView(withId(R.id.tv_title_second))
                .check(matches(withText(appContext.getString(R.string.tv_second_activity))));

        onView(withId(R.id.btn_goto_third_activity))
                .check(matches(withText(appContext.getString(R.string.btn_goto_third))));

        onView(withId(R.id.btn_show_toast))
                .check(matches(withText(appContext.getString(R.string.btn_show_toast))));
        onView(withId(R.id.btn_show_toast))
                .check(matches(not(withText(appContext.getString(R.string.btn_goto_second)))));
    }

    @Test
    public void checkToastButton() {
        onView(withId(R.id.btn_show_toast)).perform(click());
        onView(withText(appContext.getString(R.string.second_toast_message)))
                .inRoot(RootMatchers.withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkGotoThirdActivity() {
        onView(withId(R.id.btn_goto_third_activity)).perform(click());

        onView(withId(R.id.btn_goto_main)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_third)).check(matches(isDisplayed()));
    }
}
