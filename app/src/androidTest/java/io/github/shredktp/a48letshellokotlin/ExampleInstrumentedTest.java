package io.github.shredktp.a48letshellokotlin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        public MainActivity getActivity() {
            return super.getActivity();
        }
    };

//    @Before
//    public void setup() {
//        ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
//    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("io.github.shredktp.a48letshellokotlin", appContext.getPackageName());
    }

    @Test
    public void textViewHellKotlin() {
        onView(withId(R.id.tv_hello)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_hello)).check(matches(withText("Hello Kotlin")));
//        assertEquals(onView(withId(R.id.tv_hello)), "Hello Kotlin");

        assertNotEquals(onView(withId(R.id.tv_hello)), "Hello World!");
    }
}
