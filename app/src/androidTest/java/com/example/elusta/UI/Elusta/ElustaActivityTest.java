package com.example.elusta.UI.Elusta;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.elusta.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ElustaActivityTest {
    Handler mHandler;

    private static final int ITEMLIST = 5;


    @Rule
    public ActivityTestRule<ElustaActivity> elustaActivityActivityTestRule =
            new ActivityTestRule<>(ElustaActivity.class);


    @Test
    public void recycleTest() {

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {

                ElustaActivity elustaActivity = new ElustaActivity();
                RecyclerView recyclerView = elustaActivityActivityTestRule.getActivity().findViewById(R.id.recyclerView);

                elustaActivity.initList();
                int itemcount = recyclerView.getAdapter().getItemCount();
                onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(itemcount - 1));
                onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(ITEMLIST, click()));
                String item = "four";
                onView(withText(item)).check(matches(isDisplayed()));

            }
        };


        //  onView(withId(R.id.recyclerView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

/*        Espresso.onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(50, ViewActions.longClick()));*/

    }


}
