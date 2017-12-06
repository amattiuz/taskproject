package onboard.ecobee.com.tasklist.tasks;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

import onboard.ecobee.com.tasklist.taskdetail.TaskDetailView;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DatePickerFragment_MembersInjector
    implements MembersInjector<DatePickerFragment> {
  private final Provider<TaskDetailView> mViewProvider;

  public DatePickerFragment_MembersInjector(Provider<TaskDetailView> mViewProvider) {
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  public static MembersInjector<DatePickerFragment> create(Provider<TaskDetailView> mViewProvider) {
    return new DatePickerFragment_MembersInjector(mViewProvider);
  }

  @Override
  public void injectMembers(DatePickerFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mView = mViewProvider.get();
  }

  public static void injectMView(
      DatePickerFragment instance, Provider<TaskDetailView> mViewProvider) {
    instance.mView = mViewProvider.get();
  }
}
