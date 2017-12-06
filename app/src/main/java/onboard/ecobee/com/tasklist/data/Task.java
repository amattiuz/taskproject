package onboard.ecobee.com.tasklist.data;

import javax.annotation.Nullable;


public class Task{

    private final String title;
    private final String description;
    private final long dueDate;
    private final long id;

    public Task(long id,String title, @Nullable  String description, long dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getDueDate() {
        return dueDate;
    }

    public long getId() {
        return id;
    }
}
