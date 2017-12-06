package onboard.ecobee.com.tasklist.taskdetail;

import android.support.v7.app.AppCompatActivity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskDetailView_Factory implements Factory<TaskDetailView> {
  private final Provider<AppCompatActivity> activityProvider;

  public TaskDetailView_Factory(Provider<AppCompatActivity> activityProvider) {
    assert activityProvider != null;
    this.activityProvider = activityProvider;
  }

  @Override
  public TaskDetailView get() {
    return new TaskDetailView(activityProvider.get());
  }

  public static Factory<TaskDetailView> create(Provider<AppCompatActivity> activityProvider) {
    return new TaskDetailView_Factory(activityProvider);
  }

  /** Proxies {@link TaskDetailView#TaskDetailView(AppCompatActivity)}. */
  public static TaskDetailView newTaskDetailView(AppCompatActivity activity) {
    return new TaskDetailView(activity);
  }
}
