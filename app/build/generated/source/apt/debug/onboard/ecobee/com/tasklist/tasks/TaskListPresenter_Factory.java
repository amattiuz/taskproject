package onboard.ecobee.com.tasklist.tasks;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import onboard.ecobee.com.tasklist.data.TaskList;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskListPresenter_Factory implements Factory<TaskListPresenter> {
  private final Provider<TaskListView> mTaskListViewProvider;

  private final Provider<TaskList> mTaskDataRepoProvider;

  public TaskListPresenter_Factory(
      Provider<TaskListView> mTaskListViewProvider, Provider<TaskList> mTaskDataRepoProvider) {
    assert mTaskListViewProvider != null;
    this.mTaskListViewProvider = mTaskListViewProvider;
    assert mTaskDataRepoProvider != null;
    this.mTaskDataRepoProvider = mTaskDataRepoProvider;
  }

  @Override
  public TaskListPresenter get() {
    return new TaskListPresenter(mTaskListViewProvider.get(), mTaskDataRepoProvider.get());
  }

  public static Factory<TaskListPresenter> create(
      Provider<TaskListView> mTaskListViewProvider, Provider<TaskList> mTaskDataRepoProvider) {
    return new TaskListPresenter_Factory(mTaskListViewProvider, mTaskDataRepoProvider);
  }

  /** Proxies {@link TaskListPresenter#TaskListPresenter(TaskListView, TaskList)}. */
  public static TaskListPresenter newTaskListPresenter(
      Object mTaskListView, TaskList mTaskDataRepo) {
    return new TaskListPresenter((TaskListView) mTaskListView, mTaskDataRepo);
  }
}
