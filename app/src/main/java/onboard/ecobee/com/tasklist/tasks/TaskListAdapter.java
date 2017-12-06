package onboard.ecobee.com.tasklist.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import onboard.ecobee.com.tasklist.R;
import onboard.ecobee.com.tasklist.data.Task;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    private  final List<Task> mTasks;
    private final PublishSubject<Task> taskClicks = PublishSubject.create();


    public TaskListAdapter(List<Task> tasks) {
        mTasks = tasks;

    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent,false);
            return new TaskViewHolder(v);

    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
            if(holder != null){
                Task t = mTasks.get(position);
                holder.setTitle(t.getTitle());
                holder.setDescriptiom(t.getDescription());
                holder.setDate(formatDate(t));
                holder.setClickListener(() -> taskClicks.onNext(t));
            }
    }

    private String formatDate(Task t){
        if ( t.getDueDate() == 0) return "";
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(t.getDueDate());
        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy");
        return format.format(c.getTime());
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    Observable<Task> observeClicks(){
        return taskClicks;
    }

    class TaskViewHolder extends RecyclerView.ViewHolder{

        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final TextView dateView;

        TaskViewHolder(View itemView) {
            super(itemView);
            this.titleTextView = itemView.findViewById(R.id.tv_title);
            this.descriptionTextView = itemView.findViewById(R.id.tv_description);
            this.dateView = itemView.findViewById(R.id.tv_date);
        }

        void setTitle(String title){
            if(titleTextView != null)
                titleTextView.setText(title);
        }

        void setDescriptiom(String descriptiom){
            if(descriptionTextView != null)
                descriptionTextView.setText(descriptiom);
        }

        void setDate(String date){
            if(dateView != null)
                dateView.setText(date);
        }

        void setClickListener(Runnable r){
            itemView.setOnClickListener(ignore -> r.run());
        }
    }
}
