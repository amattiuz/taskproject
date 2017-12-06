package onboard.ecobee.com.tasklist.data;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimpleDataRepo_Factory implements Factory<StartableTaskList> {
  private static final SimpleDataRepo_Factory INSTANCE = new SimpleDataRepo_Factory();

  @Override
  public StartableTaskList get() {
    return new StartableTaskList();
  }

  public static Factory<StartableTaskList> create() {
    return INSTANCE;
  }

  /** Proxies {@link StartableTaskList#StartableTaskList()}. */
  public static StartableTaskList newSimpleDataRepo() {
    return new StartableTaskList();
  }
}
