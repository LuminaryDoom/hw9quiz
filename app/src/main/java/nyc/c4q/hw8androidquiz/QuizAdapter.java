package nyc.c4q.hw8androidquiz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by c4q on 11/14/17.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {
    private List<Quiz> quizList;

    public QuizAdapter(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item_view, parent, false);
        return new QuizViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(QuizViewHolder holder, int position) {
        Quiz quiz = quizList.get(position);
        holder.Bind(quiz);
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }


}
