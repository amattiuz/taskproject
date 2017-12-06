package onboard.ecobee.com.tasklist.application;

import android.support.v7.app.AppCompatActivity;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import onboard.ecobee.com.tasklist.data.StartableTaskList_Factory;
import onboard.ecobee.com.tasklist.data.TaskList;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailActivity;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailActivity_MembersInjector;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailComponent;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailPresenter;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailPresenter_Factory;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailView;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailView_Factory;
import onboard.ecobee.com.tasklist.tasks.TaskListActivity;
import onboard.ecobee.com.tasklist.tasks.TaskListActivity_MembersInjector;
import onboard.ecobee.com.tasklist.tasks.TaskListComponent;
import onboard.ecobee.com.tasklist.tasks.TaskListPresenter_Factory;
import onboard.ecobee.com.tasklist.tasks.TaskListView_Factory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  @SuppressWarnings("rawtypes")
  private Provider startableTaskListProvider;

  private Provider<Startable> provideStartableProvider;

  private Provider<Set<Startable>> setOfStartableProvider;

  private MembersInjector<TaskApplication> taskApplicationMembersInjector;

  private Provider<TaskListComponent.Builder> taskLisComponentBuilderProvider;

  private Provider<TaskDetailComponent.Builder> taskDetailsComponentBuilderProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ApplicationComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.startableTaskListProvider = DoubleCheck.provider(StartableTaskList_Factory.create());

    this.provideStartableProvider = (Provider) startableTaskListProvider;

    this.setOfStartableProvider =
        SetFactory.<Startable>builder(1, 0).addProvider(provideStartableProvider).build();

    this.taskApplicationMembersInjector =
        TaskApplication_MembersInjector.create(setOfStartableProvider);

    this.taskLisComponentBuilderProvider =
        new dagger.internal.Factory<TaskListComponent.Builder>() {
          @Override
          public TaskListComponent.Builder get() {
            return new TaskListComponentBuilder();
          }
        };

    this.taskDetailsComponentBuilderProvider =
        new dagger.internal.Factory<TaskDetailComponent.Builder>() {
          @Override
          public TaskDetailComponent.Builder get() {
            return new TaskDetailComponentBuilder();
          }
        };
  }

  @Override
  public void inject(TaskApplication target) {
    taskApplicationMembersInjector.injectMembers(target);
  }

  @Override
  public TaskListComponent.Builder taskLisComponentBuilder() {
    return taskLisComponentBuilderProvider.get();
  }

  @Override
  public TaskDetailComponent.Builder taskDetailsComponentBuilder() {
    return taskDetailsComponentBuilderProvider.get();
  }

  public static final class Builder {
    private Builder() {}

    public ApplicationComponent build() {
      return new DaggerApplicationComponent(this);
    }
  }

  private final class TaskListComponentBuilder implements TaskListComponent.Builder {
    private AppCompatActivity activity;

    @Override
    public TaskListComponent build() {
      if (activity == null) {
        throw new IllegalStateException(
            AppCompatActivity.class.getCanonicalName() + " must be set");
      }
      return new TaskListComponentImpl(this);
    }

    @Override
    public TaskListComponentBuilder activity(AppCompatActivity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }
  }

  private final class TaskListComponentImpl implements TaskListComponent {
    private Provider<AppCompatActivity> activityProvider;

    @SuppressWarnings("rawtypes")
    private Provider taskListViewProvider;

    private Provider<TaskList> provideTaskListProvider;

    @SuppressWarnings("rawtypes")
    private Provider taskListPresenterProvider;

    private MembersInjector<TaskListActivity> taskListActivityMembersInjector;

    private TaskListComponentImpl(TaskListComponentBuilder builder) {
      assert builder != null;
      initialize(builder);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final TaskListComponentBuilder builder) {

      this.activityProvider = InstanceFactory.create(builder.activity);

      this.taskListViewProvider =
          DoubleCheck.provider(TaskListView_Factory.create(activityProvider));

      this.provideTaskListProvider =
          (Provider) DaggerApplicationComponent.this.startableTaskListProvider;

      this.taskListPresenterProvider =
          DoubleCheck.provider(
              TaskListPresenter_Factory.create(taskListViewProvider, provideTaskListProvider));

      this.taskListActivityMembersInjector =
          TaskListActivity_MembersInjector.create(taskListPresenterProvider);
    }

    @Override
    public void inject(TaskListActivity target) {
      taskListActivityMembersInjector.injectMembers(target);
    }
  }

  private final class TaskDetailComponentBuilder implements TaskDetailComponent.Builder {
    private AppCompatActivity activity;

    private Long taskId;

    @Override
    public TaskDetailComponent build() {
      if (activity == null) {
        throw new IllegalStateException(
            AppCompatActivity.class.getCanonicalName() + " must be set");
      }
      if (taskId == null) {
        throw new IllegalStateException(Long.class.getCanonicalName() + " must be set");
      }
      return new TaskDetailComponentImpl(this);
    }

    @Override
    public TaskDetailComponentBuilder activity(AppCompatActivity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public TaskDetailComponentBuilder taskId(long taskId) {
      this.taskId = Preconditions.checkNotNull(taskId);
      return this;
    }
  }

  private final class TaskDetailComponentImpl implements TaskDetailComponent {
    private Provider<AppCompatActivity> activityProvider;

    private Provider<TaskDetailView> taskDetailViewProvider;

    private Provider<TaskList> provideTaskListProvider;

    private Provider<Long> taskIdProvider;

    private Provider<TaskDetailPresenter> taskDetailPresenterProvider;

    private MembersInjector<TaskDetailActivity> taskDetailActivityMembersInjector;

    private TaskDetailComponentImpl(TaskDetailComponentBuilder builder) {
      assert builder != null;
      initialize(builder);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final TaskDetailComponentBuilder builder) {

      this.activityProvider = InstanceFactory.create(builder.activity);

      this.taskDetailViewProvider = TaskDetailView_Factory.create(activityProvider);

      this.provideTaskListProvider =
          (Provider) DaggerApplicationComponent.this.startableTaskListProvider;

      this.taskIdProvider = InstanceFactory.create(builder.taskId);

      this.taskDetailPresenterProvider =
          DoubleCheck.provider(
              TaskDetailPresenter_Factory.create(
                  taskDetailViewProvider, provideTaskListProvider, taskIdProvider));

      this.taskDetailActivityMembersInjector =
          TaskDetailActivity_MembersInjector.create(taskDetailPresenterProvider);
    }

    @Override
    public void inject(TaskDetailActivity target) {
      taskDetailActivityMembersInjector.injectMembers(target);
    }
  }
}
