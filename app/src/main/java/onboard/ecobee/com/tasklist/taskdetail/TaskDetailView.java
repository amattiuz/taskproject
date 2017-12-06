package onboard.ecobee.com.tasklist.taskdetail;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import onboard.ecobee.com.tasklist.R;

public class TaskDetailView  {
    private final AppCompatActivity activity;

    private Button mCreateTaskBtn;
    private EditText mEditTextTitle;
    private EditText mEditTextDescription;
    private Toolbar mToolbar;
    private Button mButtonSetDate;

    private final PublishSubject<Boolean>  mCreateTaskClicks = PublishSubject.create();
    private final PublishSubject<Long> mTaskDateSelected = PublishSubject.create();
    private final PublishSubject<Boolean> mSetDateClicks = PublishSubject.create();


    @Inject
    TaskDetailView(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void start() {
        mToolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(mToolbar);

        mButtonSetDate = activity.findViewById(R.id.btn_set_date);
        mButtonSetDate.setOnClickListener(click -> mSetDateClicks.onNext(true));
        mEditTextTitle = activity.findViewById(R.id.et_text_title);
        mEditTextDescription = activity.findViewById(R.id.et_task_desc);
        mCreateTaskBtn = activity.findViewById(R.id.btn_create_task);
        mCreateTaskBtn.setOnClickListener(click -> mCreateTaskClicks.onNext(true) );
    }


    public void stop() {
        activity.finish();
    }

    public Observable<Boolean> listenToCreateTaskClicks() {
        return mCreateTaskClicks;
    }

    public Observable<Boolean> listenToSetDateClicks() {
        return mSetDateClicks;
    }

    public PublishSubject<Long> listenToTaskDateChanges() {
        return mTaskDateSelected;
    }

    public String getTitle() {
        return mEditTextTitle.getText().toString();
    }

    public String getDescription() {
        return mEditTextDescription.getText().toString();
    }

    private void publishDate(int year, int month, int dayOfMonth){
        final Calendar c = Calendar.getInstance();
        c.set(year, month, dayOfMonth);
        mTaskDateSelected.onNext(c.getTimeInMillis());
    }

    public void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        new DatePickerDialog(activity,
                (view, year, month, dayOfMonth) -> publishDate(year, month, dayOfMonth),
                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void setDescription(String description){
        mEditTextDescription.setText(description);
    }

    public void setTitle(String title){
        mEditTextTitle.setText(title);
    }

    public void setUpdateTaskButtonText(){
        mCreateTaskBtn.setText(R.string.update_task);
    }


}
