package nyc.c4q.hw8androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MillennialQuiz extends AppCompatActivity {

    ArrayList<String> questions = new ArrayList<>();
    @BindView(R.id.question_textView)
    TextView question;

    @BindView(R.id.button1)
    Button button1;

    @OnClick(R.id.button1)
    public void sendAnswer1() {
        int i = 0;
        String compare = button1.getText().toString();
        if (flag == 0) checkAnswer(compare);
    }

    @BindView(R.id.button2)
    Button button2;

    @OnClick(R.id.button2)
    public void sendAnswer2() {
        String compare = button2.getText().toString();
        if (flag == 0) checkAnswer(compare);
        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


    private int numberYes;

    private int flag = 0;

    private int counter = 0;
    String[] options = new String[]{"Yes", "No"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_millennial_quiz);
        Intent intent = getIntent();
        ButterKnife.bind(this);
        addQuestions();
        newQuestion();
        Toast.makeText(getApplicationContext(), "Are you a millenial?", Toast.LENGTH_SHORT).show();
    }

    public void addQuestions() {
        questions.add("Did you ever connect to AOL using dial-up?");
        questions.add("Ever eaten a delicious Handi-Snack?");
        questions.add("Do you remember Limewire?");
        questions.add("Ever drink Surge?");
        questions.add("Did you ever wear wide-leg pants?");
    }

    public void newQuestion() {
        question.setText(questions.get(counter));
        loadAnswers();
    }

    public void loadAnswers() {
        for (int j = 0; j < options.length; j++) {
            switch (j) {
                case 0:
                    button1.setText(options[j]);
                    break;
                case 1:
                    button2.setText(options[j]);
                    break;
            }
        }
    }

    public void checkAnswer(String response) {
        if (response == "Yes") {
            Toast.makeText(getApplicationContext(), "Yaaaaaas", Toast.LENGTH_SHORT).show();
            numberYes++;
        } else {
            Toast.makeText(getApplicationContext(), "Awww", Toast.LENGTH_SHORT).show();
        }

        if (counter == 4) {
            if (numberYes >= 4) {
                question.setText("Great YOU A TRUE MILLENIAL");
            } else if (numberYes <= 2) {
                question.setText("Hmmmm not close enough");
            } else if (numberYes <=1) {
                question.setText("How do you even know how to download an app");
            }
            button1.setText("How Millenial are you? " + numberYes+"/5");
            button2.setText("Return to menu");
            flag = 1;
        } else {
            counter++;
            newQuestion();
        }
    }

}

