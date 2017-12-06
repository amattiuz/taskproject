package onboard.ecobee.com.tasklist.data;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StartableTaskList_Factory implements Factory<StartableTaskList> {
  private static final StartableTaskList_Factory INSTANCE = new StartableTaskList_Factory();

  @Override
  public StartableTaskList get() {
    return new StartableTaskList();
  }

  public static Factory<StartableTaskList> create() {
    return INSTANCE;
  }

  /** Proxies {@link StartableTaskList#StartableTaskList()}. */
  public static StartableTaskList newStartableTaskList() {
    return new StartableTaskList();
  }
}
