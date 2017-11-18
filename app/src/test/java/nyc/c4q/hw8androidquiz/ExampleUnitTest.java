package nyc.c4q.hw8androidquiz;

import android.content.Intent;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ExampleUnitTest {

    private MainActivity activity;
    private Button buttonpress;

    @Before
    public void setUp() throws Exception{
        activity = new MainActivity();
        activity.onCreate(null);
        buttonpress = (Button) activity.findViewById(R.id.go_to_quiz_button);
    }

    @Test
    public void shouldStartNewActivity(){
        buttonpress.performClick();
        // 7// 8
        ShadowActivity shadowActivity = shadowOf(activity);
        // 9
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        // 10
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        // 11
        assertThat(shadowIntent.getIntentClass().getName(), equalTo(MillennialQuiz.class.getName()));
    }




    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

}