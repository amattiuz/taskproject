package onboard.ecobee.com.tasklist.tasks;

import android.support.v7.app.AppCompatActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import onboard.ecobee.com.tasklist.dagger.ActivityScope;
import onboard.ecobee.com.tasklist.dagger.ComponentBuilder;
import onboard.ecobee.com.tasklist.taskdetail.TaskDetailActivity;

@ActivityScope
@Subcomponent
public interface TaskListComponent {

    void inject(TaskListActivity target);

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<TaskListComponent> {
        @BindsInstance
        Builder activity(AppCompatActivity activity);
    }

}
