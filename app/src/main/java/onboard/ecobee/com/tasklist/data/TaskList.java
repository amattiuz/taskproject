package onboard.ecobee.com.tasklist.data;

import java.util.List;

import io.reactivex.Observable;

public interface TaskList {


    Observable<List<Task>> getAllTasks();

    void createNewTask(Task task);

}
