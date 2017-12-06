package onboard.ecobee.com.tasklist.common;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.test.mock.MockApplication;

import onboard.ecobee.com.tasklist.application.ApplicationComponent;
import onboard.ecobee.com.tasklist.application.TaskApplication;

/**
 * Created by amanda on 28/11/17.
 */

public class BaseActivity extends AppCompatActivity {

    protected ApplicationComponent getComponent(){
        return ((TaskApplication) getApplication()).getComponent();
    }
}
