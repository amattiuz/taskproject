package onboard.ecobee.com.tasklist.taskdetail;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskDetailActivity_MembersInjector
    implements MembersInjector<TaskDetailActivity> {
  private final Provider<TaskDetailPresenter> mPresenterProvider;

  public TaskDetailActivity_MembersInjector(Provider<TaskDetailPresenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<TaskDetailActivity> create(
      Provider<TaskDetailPresenter> mPresenterProvider) {
    return new TaskDetailActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(TaskDetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      TaskDetailActivity instance, Provider<TaskDetailPresenter> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
