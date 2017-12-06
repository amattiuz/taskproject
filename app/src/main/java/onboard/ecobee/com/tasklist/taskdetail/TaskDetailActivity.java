package onboard.ecobee.com.tasklist.taskdetail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import onboard.ecobee.com.tasklist.R;
import onboard.ecobee.com.tasklist.common.BaseActivity;

public class TaskDetailActivity extends BaseActivity {

    @Inject
    TaskDetailPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        getComponent().taskDetailsComponentBuilder()
                .activity(this)
                .taskId(getIntent().getLongExtra("task", 0))
                .build().inject(this);


        mPresenter.start();
    }



}
