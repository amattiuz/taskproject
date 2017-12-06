package onboard.ecobee.com.tasklist.tasks;


import java.util.Random;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import onboard.ecobee.com.tasklist.dagger.ActivityScope;
import onboard.ecobee.com.tasklist.data.Task;
import onboard.ecobee.com.tasklist.data.TaskList;

@ActivityScope
 class TaskListPresenter  {

    private final TaskListView mTaskListView;
    private final TaskList mTaskDataRepo;

    private  CompositeDisposable mDisposables;

    @Inject
    TaskListPresenter(TaskListView mTaskListView, TaskList mTaskDataRepo) {
        this.mTaskListView = mTaskListView;
        this.mTaskDataRepo = mTaskDataRepo;
        this.mDisposables = new CompositeDisposable();
    }

    void start() {
        mTaskListView.start();

        mDisposables.addAll(
                mTaskDataRepo.getAllTasks()
                        .flatMap(mTaskListView::showTasks)
                        .map(Task::getId)
                        .subscribe(mTaskListView::goToTaskDetail, Throwable::printStackTrace),
                mTaskListView.getFabClicks()
                        .subscribe(ignore -> mTaskListView.goToTaskDetail((new Random()).nextLong()), Throwable::printStackTrace)
                );

    }

    void stop() {
        mDisposables.dispose();
    }

}
