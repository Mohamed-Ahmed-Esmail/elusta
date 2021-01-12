package com.example.elusta;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.elusta.UI.Elusta.ElustaActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final int ITEMLIST = 5;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.elusta", appContext.getPackageName());

    }

    @Rule
    public ActivityTestRule<ElustaActivity> elustaActivityActivityTestRule =
            new ActivityTestRule<ElustaActivity>(ElustaActivity.class);

    @Test
    public void recycleTest() {
/*        Espresso.onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(50, ViewActions.longClick()));*/


         RecyclerView recyclerView = elustaActivityActivityTestRule.getActivity().findViewById(R.id.recyclerView);
         int itemcount = recyclerView.getAdapter().getItemCount();
         Espresso.onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(itemcount-1));
         Espresso.onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(ITEMLIST, click()));
         String item = "five";
         Espresso.onView(withText(item)).check(matches(isDisplayed()));


    }

}