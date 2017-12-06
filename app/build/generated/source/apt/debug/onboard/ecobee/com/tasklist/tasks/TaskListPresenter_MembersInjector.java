package onboard.ecobee.com.tasklist.tasks;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailPresenter;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskListPresenter_MembersInjector implements MembersInjector<TaskListPresenter> {
  private final Provider<TaskDetailPresenter> detailPresenterProvider;

  public TaskListPresenter_MembersInjector(Provider<TaskDetailPresenter> detailPresenterProvider) {
    assert detailPresenterProvider != null;
    this.detailPresenterProvider = detailPresenterProvider;
  }

  public static MembersInjector<TaskListPresenter> create(
      Provider<TaskDetailPresenter> detailPresenterProvider) {
    return new TaskListPresenter_MembersInjector(detailPresenterProvider);
  }

  @Override
  public void injectMembers(TaskListPresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.detailPresenter = detailPresenterProvider.get();
  }

  public static void injectDetailPresenter(
      TaskListPresenter instance, Provider<TaskDetailPresenter> detailPresenterProvider) {
    instance.detailPresenter = detailPresenterProvider.get();
  }
}
