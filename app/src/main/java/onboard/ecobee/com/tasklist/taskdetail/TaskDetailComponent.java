package onboard.ecobee.com.tasklist.taskdetail;

import android.support.v7.app.AppCompatActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import onboard.ecobee.com.tasklist.dagger.ActivityScope;
import onboard.ecobee.com.tasklist.dagger.ComponentBuilder;
import onboard.ecobee.com.tasklist.tasks.TaskListComponent;

/**
 * Created by amanda on 30/11/17.
 */

@ActivityScope
@Subcomponent
public interface TaskDetailComponent {

    void inject(TaskDetailActivity target);

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<TaskDetailComponent> {
        @BindsInstance
        TaskDetailComponent.Builder activity(AppCompatActivity activity);
        @BindsInstance
        TaskDetailComponent.Builder taskId(long taskId);
    }

}
