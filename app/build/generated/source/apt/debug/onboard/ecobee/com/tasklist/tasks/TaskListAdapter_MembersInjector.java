package onboard.ecobee.com.tasklist.tasks;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskListAdapter_MembersInjector implements MembersInjector<TaskListAdapter> {
  private final Provider<TaskListView> mViewProvider;

  public TaskListAdapter_MembersInjector(Provider<TaskListView> mViewProvider) {
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  public static MembersInjector<TaskListAdapter> create(Provider<TaskListView> mViewProvider) {
    return new TaskListAdapter_MembersInjector(mViewProvider);
  }

  @Override
  public void injectMembers(TaskListAdapter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mView = mViewProvider.get();
  }

  public static void injectMView(TaskListAdapter instance, Provider<TaskListView> mViewProvider) {
    instance.mView = mViewProvider.get();
  }
}
