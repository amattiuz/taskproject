// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package onboard.ecobee.com.tasklist.dagger;

public final class DaggerTaskComponent {
  private DaggerTaskComponent(Builder builder) {
    assert builder != null;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static TaskComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {}

    public TaskComponent build() {
      return new DaggerTaskComponent(this);
    }
  }
}
