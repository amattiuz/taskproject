package onboard.ecobee.com.tasklist.taskdetail;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import onboard.ecobee.com.tasklist.data.Task;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskDetailPresenter_MembersInjector
    implements MembersInjector<TaskDetailPresenter> {
  private final Provider<Task> mNewTaskProvider;

  public TaskDetailPresenter_MembersInjector(Provider<Task> mNewTaskProvider) {
    assert mNewTaskProvider != null;
    this.mNewTaskProvider = mNewTaskProvider;
  }

  public static MembersInjector<TaskDetailPresenter> create(Provider<Task> mNewTaskProvider) {
    return new TaskDetailPresenter_MembersInjector(mNewTaskProvider);
  }

  @Override
  public void injectMembers(TaskDetailPresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNewTask = mNewTaskProvider.get();
  }

  public static void injectMNewTask(TaskDetailPresenter instance, Provider<Task> mNewTaskProvider) {
    instance.mNewTask = mNewTaskProvider.get();
  }
}
