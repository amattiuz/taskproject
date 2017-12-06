package onboard.ecobee.com.tasklist.tasks;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskListActivity_MembersInjector implements MembersInjector<TaskListActivity> {
  private final Provider<TaskListPresenter> mPresenterProvider;

  public TaskListActivity_MembersInjector(Provider<TaskListPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TaskListActivity> create(
      Provider<TaskListPresenter> mPresenterProvider) {
    return new TaskListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TaskListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      TaskListActivity instance, Provider<TaskListPresenter> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
