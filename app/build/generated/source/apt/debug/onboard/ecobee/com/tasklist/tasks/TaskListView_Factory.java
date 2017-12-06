package onboard.ecobee.com.tasklist.tasks;

import android.support.v7.app.AppCompatActivity;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskListView_Factory implements Factory<TaskListView> {
  private final Provider<AppCompatActivity> activityProvider;

  public TaskListView_Factory(Provider<AppCompatActivity> activityProvider) {
    assert activityProvider != null;
    this.activityProvider = activityProvider;
  }

  @Override
  public TaskListView get() {
    return new TaskListView(activityProvider.get());
  }

  public static Factory<TaskListView> create(Provider<AppCompatActivity> activityProvider) {
    return new TaskListView_Factory(activityProvider);
  }

  /** Proxies {@link TaskListView#TaskListView(AppCompatActivity)}. */
  public static TaskListView newTaskListView(AppCompatActivity activity) {
    return new TaskListView(activity);
  }
}
