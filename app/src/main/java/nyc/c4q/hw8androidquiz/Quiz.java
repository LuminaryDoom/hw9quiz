package nyc.c4q.hw8androidquiz;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

/**
 * Created by c4q on 11/14/17.
 */

public class Quiz {
    String title;
    Drawable image;

    public Quiz(String title, Drawable image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }
}
