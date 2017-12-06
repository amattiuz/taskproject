package onboard.ecobee.com.tasklist.taskdetail;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import onboard.ecobee.com.tasklist.data.TaskList;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskDetailPresenter_Factory implements Factory<TaskDetailPresenter> {
  private final Provider<TaskDetailView> mViewProvider;

  private final Provider<TaskList> mDataSourceProvider;

  private final Provider<Long> taskIdProvider;

  public TaskDetailPresenter_Factory(
      Provider<TaskDetailView> mViewProvider,
      Provider<TaskList> mDataSourceProvider,
      Provider<Long> taskIdProvider) {
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
    assert mDataSourceProvider != null;
    this.mDataSourceProvider = mDataSourceProvider;
    assert taskIdProvider != null;
    this.taskIdProvider = taskIdProvider;
  }

  @Override
  public TaskDetailPresenter get() {
    return new TaskDetailPresenter(
        mViewProvider.get(), mDataSourceProvider.get(), taskIdProvider.get());
  }

  public static Factory<TaskDetailPresenter> create(
      Provider<TaskDetailView> mViewProvider,
      Provider<TaskList> mDataSourceProvider,
      Provider<Long> taskIdProvider) {
    return new TaskDetailPresenter_Factory(mViewProvider, mDataSourceProvider, taskIdProvider);
  }

  /** Proxies {@link TaskDetailPresenter#TaskDetailPresenter(TaskDetailView, TaskList, long)}. */
  public static TaskDetailPresenter newTaskDetailPresenter(
      TaskDetailView mView, TaskList mDataSource, long taskId) {
    return new TaskDetailPresenter(mView, mDataSource, taskId);
  }
}
