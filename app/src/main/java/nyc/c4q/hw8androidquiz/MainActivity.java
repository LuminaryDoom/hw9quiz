package nyc.c4q.hw8androidquiz;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.*;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.quiz_recycler_view)
    RecyclerView quizRecycler;
    @BindDrawable(R.drawable.millenial_quiz_image)
    Drawable quiz1;
    @BindDrawable(R.drawable.mnemonic_quiz_image)
    Drawable quiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(new Quiz("Are you a Millenial Quiz", quiz1));
        quizzes.add(new Quiz("Mnemonics quiz", quiz2));

        QuizAdapter quizAdapter = new QuizAdapter(quizzes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        quizRecycler.setAdapter(quizAdapter);
        quizRecycler.setLayoutManager(linearLayoutManager);
    }
}
