package edu.neu.khoury.madsea.chrisholzheu.data;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import edu.neu.khoury.madsea.chrisholzheu.ToDoItemContentConverter;

@Entity(tableName = "todo_table")
public class ToDo {

//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="todo_id")
    private int todoId;

    @NonNull
    @ColumnInfo(name="title")
    private String todoTitle;

    @NonNull
    @ColumnInfo(name="details")
    private String todoDetails;

    @NonNull
    @ColumnInfo(name="tags")
    @TypeConverters(ToDoItemContentConverter.class)
    private Set<String> todoTags;

    @NonNull
    @ColumnInfo(name="deadline")
    @TypeConverters(ToDoItemContentConverter.class)
    private LocalDateTime deadline;

    @NonNull
    @ColumnInfo(name="reminder_date")
    @TypeConverters(ToDoItemContentConverter.class)
    private LocalDateTime reminderDate;

    @NonNull
    private boolean reminder;

    @NonNull
    @ColumnInfo(name="latitude")
    private String latitude;

    @NonNull
    @ColumnInfo(name="longitude")
    private String longitude;

//    @ColumnInfo(name = "address")
//    private TaskAddress address;

    @NonNull
    private boolean complete;

    @NonNull
    @ColumnInfo(name="position_order")
    private int todoOrder;


    public ToDo(ToDo toDo) {
        setTodoId(toDo.getTodoId());
        setTodoTags(toDo.getTodoTags());
        setTodoTitle(toDo.getTodoTitle());
        setTodoDetails((toDo.getTodoDetails()));
        setDeadline(toDo.getDeadline());
        setReminder(toDo.isReminder());
        setReminderDate(toDo.getReminderDate());
        setComplete(toDo.isComplete());
        setTodoOrder(toDo.getTodoOrder());
        setLatitude(toDo.getLatitude());
        setLongitude(toDo.getLongitude());
//        setAddress(toDo.getAddress());
    }

    public ToDo() {
        todoTitle = "";
        todoDetails = "";
        deadline = LocalDateTime.now();
        reminderDate = LocalDateTime.now();
        todoTags = new HashSet<String>();
        reminder = false;
        complete = false;
        todoOrder = 0;
        latitude = "1";
        longitude = "1";
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getTodoOrder() {
        return todoOrder;
    }

    public void setTodoOrder(int todoOrder) {
        this.todoOrder = todoOrder;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDetails() {
        return todoDetails;
    }

    public void setTodoDetails(String todoDetails) {
        this.todoDetails = todoDetails;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDateTime reminderDate) {
        this.reminderDate = reminderDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Set<String> getTodoTags() {
        return todoTags;
    }

    public void setTodoTags(Set<String> todoTags) {
        this.todoTags = todoTags;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude( String latitude) {
        this.latitude = latitude;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude( String longitude) {
        this.longitude = longitude;
    }

    public String createLatLong () {
        String mLatitude = this.latitude;
        String mLongitude = this.longitude;
        String latLang = mLatitude + " " + mLongitude;
        return latLang;
    }

//    @NonNull
//    public TaskAddress getAddress() {
//        return address;
//    }
//
//    public void setAddress(@NonNull TaskAddress address) {
//        this.address = address;
//    }

    public static DiffUtil.ItemCallback<ToDo> toDoItemCallback =
            new DiffUtil.ItemCallback<ToDo>() {
                @Override
                public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
                    return oldItem == newItem;
                }

                @Override
                public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return todoId == toDo.todoId && reminder == toDo.reminder && complete == toDo.complete &&
                todoOrder == toDo.todoOrder && todoTitle.equals(toDo.todoTitle) &&
                todoDetails.equals(toDo.todoDetails) && todoTags.equals(toDo.todoTags) &&
                deadline.equals(toDo.deadline) && reminderDate.equals(toDo.reminderDate) &&
                latitude.equals(toDo.latitude) && longitude.equals(toDo.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, todoTitle, todoDetails, todoTags, deadline, reminderDate,
                reminder, latitude, longitude, complete, todoOrder);
    }
}
