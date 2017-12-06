package onboard.ecobee.com.tasklist.data;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Task_Factory implements Factory<Task> {
  private static final Task_Factory INSTANCE = new Task_Factory();

  @Override
  public Task get() {
    return new Task();
  }

  public static Factory<Task> create() {
    return INSTANCE;
  }
}
