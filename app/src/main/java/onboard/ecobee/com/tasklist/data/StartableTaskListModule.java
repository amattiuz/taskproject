package onboard.ecobee.com.tasklist.data;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import onboard.ecobee.com.tasklist.application.Startable;
import onboard.ecobee.com.tasklist.dagger.ApplicationScope;

@Module
public interface StartableTaskListModule {
    @Binds
    TaskList provideTaskList(StartableTaskList repo);

    @Binds
    @IntoSet
    Startable provideStartable(StartableTaskList repo);

}
