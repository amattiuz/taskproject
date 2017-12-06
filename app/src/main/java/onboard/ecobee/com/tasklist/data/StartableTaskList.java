package onboard.ecobee.com.tasklist.data;

import android.annotation.SuppressLint;
import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import onboard.ecobee.com.tasklist.application.Startable;
import onboard.ecobee.com.tasklist.dagger.ApplicationScope;

@ApplicationScope
class StartableTaskList implements Startable, TaskList {

    private final BehaviorSubject<List<Task>> taskMap;
    private final PublishSubject<Task> newTasks;

    @Inject
    StartableTaskList() {
        taskMap = BehaviorSubject.create();
        newTasks = PublishSubject.create();
    }

    @SuppressLint("RxLeakedSubscription")
    @Override
    public void start( ) {
        LinkedHashMap<Long, Task> initialMap = new LinkedHashMap<>();
        Task t1 = new Task(1, "Task 1", "First task", 0);
        Task t2 = new Task(2, "Task 2", "Yet another empty task", 0);
        initialMap.put(t1.getId(), t1);
        initialMap.put(t2.getId(), t2);
        newTasks.scan(initialMap, this::addToMap)
                .map(LinkedHashMap::values)
                .map(ArrayList::new)
                .subscribe(taskMap::onNext, Throwable::printStackTrace);
    }

    private LinkedHashMap<Long, Task> addToMap(LinkedHashMap<Long, Task> oldValues, Task newTask) {
        LinkedHashMap<Long, Task> combinedMap = new LinkedHashMap<>();
        combinedMap.putAll(oldValues);
        combinedMap.put(newTask.getId(), newTask);
        return combinedMap;
    }

    @Override
    public Observable<List<Task>> getAllTasks() {
        return taskMap;
    }


    @Override
    public void createNewTask(Task task) {
        newTasks.onNext(task);
    }


}
