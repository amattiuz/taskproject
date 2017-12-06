package onboard.ecobee.com.tasklist.application;

import dagger.MembersInjector;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskApplication_MembersInjector implements MembersInjector<TaskApplication> {
  private final Provider<Set<Startable>> startablesProvider;

  public TaskApplication_MembersInjector(Provider<Set<Startable>> startablesProvider) {
    assert startablesProvider != null;
    this.startablesProvider = startablesProvider;
  }

  public static MembersInjector<TaskApplication> create(
      Provider<Set<Startable>> startablesProvider) {
    return new TaskApplication_MembersInjector(startablesProvider);
  }

  @Override
  public void injectMembers(TaskApplication instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.startables = startablesProvider.get();
  }

  public static void injectStartables(
      TaskApplication instance, Provider<Set<Startable>> startablesProvider) {
    instance.startables = startablesProvider.get();
  }
}
