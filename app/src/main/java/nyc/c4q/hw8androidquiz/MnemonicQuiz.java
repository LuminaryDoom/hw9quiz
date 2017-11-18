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

public class MnemonicQuiz extends AppCompatActivity {
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
    }

    @BindView(R.id.button3)
    Button button3;

    @OnClick(R.id.button3)
    public void sendAnswer3() {
        String compare = button3.getText().toString();
        if (flag == 0) checkAnswer(compare);
        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @BindView(R.id.button4)
    Button button4;

    @OnClick(R.id.button4)
    public void sendAnswer4() {
        String compare = button4.getText().toString();
        if (flag == 0) checkAnswer(compare);
    }

    private int numberCorrect;

    private int numberWrong;

    private int flag = 0;

    private int counter = 0;
    String[][] answers = new String[][]{
            {"The Great Lakes", "Compass directions", "Greek philosophers", "Rules for health inspections"},
            {"Order of Operations", "Theorum of Calculus", "Quadratic Formula", "Trigonometric Functions"},
            {"The order of sharp keys", "The order of flat keys", "Lines of trebel clef", "Lines of Bass cleff"},
            {"Phases of taxonomy", "The major fungal classes", "Multicellular organism", "Phases of the cell cycle"},
            {"Canadian capital cities", "Mountain ranges of Eurasia", "Moons of jupiter", "Objects found in the oort cloud"}
    };

    String[] correctAnswers = new String[]{"Compass directions", "Order of Operations", "Lines of trebel clef", "Phases of the cell cycle", "Moons of jupiter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnemonic_quiz);
        Intent intent = getIntent();
        ButterKnife.bind(this);
        addQuestions();
        newQuestion();
        Toast.makeText(getApplicationContext(),"Guess what these Mnemonics stand for",Toast.LENGTH_SHORT).show();
    }

    public void addQuestions() {
        questions.add("Never Eat Soggy Waffles");
        questions.add("Please Excuse My Dear Ausnt Sally");
        questions.add("Every Good Boy Deserves Fudge");
        questions.add("Idiot, Pass Me Another Tequila");
        questions.add("I Eat Green Cows");
    }

    public void newQuestion() {
        question.setText(questions.get(counter));
        loadAnswers();
    }

    public void loadAnswers() {
        for (int j = 0; j < answers[counter].length; j++) {
            switch (j) {
                case 0:
                    button1.setText(answers[counter][j]);
                    break;
                case 1:
                    button2.setText(answers[counter][j]);
                    break;
                case 2:
                    button3.setText(answers[counter][j]);
                    break;
                case 3:
                    button4.setText(answers[counter][j]);
                    break;
            }
        }
    }

    public void checkAnswer(String response) {
        if (response == correctAnswers[counter].toString()) {
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            numberCorrect++;
        } else {
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            numberWrong++;
        }

        if (counter == 4) {
            question.setText("Good Job");
            button1.setText("You got " + numberCorrect + " correct");
            button2.setText("You got " + numberWrong + " wrong");
            button3.setText("Press Button to return to menu");
            button4.setText("");
            flag = 1;
        } else {
            counter++;
            newQuestion();
        }
    }

}
