package nyc.c4q.hw8androidquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.*;

import butterknife.*;

import android.view.*;

/**
 * Created by c4q on 11/14/17.
 */

public class QuizViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.quiz_title)
    TextView title;
    @BindView(R.id.go_to_quiz_button)
    Button take;
    @BindView(R.id.quiz_image_view)
    ImageView quizImage;
    private final Context context;

    public QuizViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public void Bind(final Quiz quiz) {
        title.setText(quiz.getTitle());
        quizImage.setImageDrawable(quiz.getImage());
        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch (getAdapterPosition()) {
                    case 0:
                        intent = new Intent(context, MillennialQuiz.class);
                        break;
                    case 1:
                        intent = new Intent(context, MnemonicQuiz.class);
                        break;
                }
                context.startActivity(intent);
            }
        });

    }
}
