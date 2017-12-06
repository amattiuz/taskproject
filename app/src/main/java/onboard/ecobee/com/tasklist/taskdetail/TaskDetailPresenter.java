package onboard.ecobee.com.tasklist.taskdetail;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import onboard.ecobee.com.tasklist.dagger.ActivityScope;
import onboard.ecobee.com.tasklist.data.Task;
import onboard.ecobee.com.tasklist.data.TaskList;

@ActivityScope
public class TaskDetailPresenter {

    private final TaskDetailView mView;
    private final TaskList mDataSource;
    private final CompositeDisposable mDisposables;

    private final long taskId;
    private long date;

    @Inject
    TaskDetailPresenter(TaskDetailView mView, TaskList mDataSource, long taskId) {
        this.mView = mView;
        this.mDataSource = mDataSource;
        this.taskId = taskId;
        this.mDisposables = new CompositeDisposable();
    }

    void start() {
        mView.start();

        loadExistingTask();

        mDisposables.addAll(
                mView.listenToCreateTaskClicks()
                        .map(ignore -> new Task(taskId, mView.getTitle(), mView.getDescription(), date))
                        .doOnNext(mDataSource::createNewTask)
                        .subscribe(t -> mView.stop(), Throwable::printStackTrace),
                mView.listenToTaskDateChanges()
                        .subscribe(newDate -> date = newDate, Throwable::printStackTrace),
                mView.listenToSetDateClicks()
                        .subscribe(click -> mView.showDatePickerDialog(), Throwable::printStackTrace)
        );
    }

    void stop() {
        mDisposables.dispose();
    }

    private void loadExistingTask() {
        mDisposables.add(mDataSource.getAllTasks()
                .map(this::getCurrentTask)
                .subscribe(this::applyToView, Throwable::printStackTrace));
    }

    private void applyToView(Task task) {
        mView.setTitle(task.getTitle());
        mView.setDescription(task.getDescription());
        mView.setUpdateTaskButtonText();
        date = task.getDueDate();
    }

    private Task getCurrentTask(List<Task> allTasks) {
        for (Task task : allTasks) {
            if (taskId == task.getId()) {
                return task;
            }
        }
        return new Task(taskId, "", "", 0);
    }

}
