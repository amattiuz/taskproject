package onboard.ecobee.com.tasklist.application;

import dagger.Component;
import onboard.ecobee.com.tasklist.dagger.ApplicationScope;
import onboard.ecobee.com.tasklist.data.StartableTaskListModule;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailComponent;
import onboard.ecobee.com.tasklist.tasks.TaskListComponent;

/**
 * Created by amanda on 28/11/17.
 */

@ApplicationScope
@Component(modules = {StartableTaskListModule.class})
public interface ApplicationComponent  {
    void inject(TaskApplication target);
    TaskListComponent.Builder taskLisComponentBuilder();
    TaskDetailComponent.Builder taskDetailsComponentBuilder();
}
