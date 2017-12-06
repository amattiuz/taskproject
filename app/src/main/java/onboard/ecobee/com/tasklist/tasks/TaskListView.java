package onboard.ecobee.com.tasklist.tasks;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import onboard.ecobee.com.tasklist.R;
import onboard.ecobee.com.tasklist.dagger.ActivityScope;
import onboard.ecobee.com.tasklist.data.Task;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailActivity;

@ActivityScope
class TaskListView {
    private final AppCompatActivity activity;
    private RecyclerView mRecyclerView;

    private final PublishSubject<Object> fabClicks = PublishSubject.create();

    @Inject
    TaskListView(AppCompatActivity activity) {
        this.activity = activity;
    }

    void start() {
        mRecyclerView = activity.findViewById(R.id.recycler_view);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

        Toolbar mToolbar = activity.findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.str_task_list_title);
        activity.setSupportActionBar(mToolbar);

        FloatingActionButton mFab = activity.findViewById(R.id.fab);
        mFab.setImageResource(R.drawable.ic_note_add_black_24dp);
        mFab.setOnClickListener(fabClicks::onNext);
    }


    Observable<Object> getFabClicks() {
        return fabClicks;
    }

    void goToTaskDetail(long id) {
        Intent detailIntent = new Intent(activity, TaskDetailActivity.class);
        detailIntent.putExtra("task", id);
        activity.startActivity(detailIntent);
    }

    Observable<Task> showTasks(List<Task> tasks) {
        TaskListAdapter adapter = new TaskListAdapter(tasks);
        mRecyclerView.setAdapter(adapter);
        return adapter.observeClicks();
    }
}
