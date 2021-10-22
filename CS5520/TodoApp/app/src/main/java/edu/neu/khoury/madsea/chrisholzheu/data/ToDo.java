package edu.neu.khoury.madsea.chrisholzheu.data;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
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
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int todoId;

    @NonNull
    private String todoTitle;

    @NonNull
    private String todoDetails;

    @NonNull
    @TypeConverters(ToDoItemContentConverter.class)
    private Set<String> todoTags;

    @NonNull
    @TypeConverters(ToDoItemContentConverter.class)
    private LocalDateTime deadline;

//    @NonNull
//    @TypeConverters(ToDoItemContentConverter.class)
//    private LocalDateTime reminderDate;

    @NonNull
    private boolean reminder;

    @NonNull
    private boolean complete;

    public ToDo(ToDo toDo) {
        setTodoId(toDo.getTodoId());
        setTodoTags(toDo.getTodoTags());
        setTodoTitle(toDo.getTodoTitle());
        setTodoDetails((toDo.getTodoDetails()));
        setDeadline(toDo.getDeadline());
        setReminder(toDo.isReminder());
//        setReminderDate(toDo.getReminderDate());
        setComplete(toDo.isComplete());
    }

    public ToDo() {
        todoTitle = "";
        todoDetails = "";
        deadline = LocalDateTime.now();
//        reminderDate = LocalDateTime.now();
        todoTags = new HashSet<String>();
        reminder = false;
        complete = false;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
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

//    public LocalDateTime getReminderDate() {
//        return reminderDate;
//    }
//
//    public void setReminderDate(LocalDateTime reminderDate) {
//        this.reminderDate = reminderDate;
//    }

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
        return todoId == toDo.todoId && reminder == toDo.reminder && complete == toDo.complete
                && todoTitle.equals(toDo.todoTitle) && todoDetails.equals(toDo.todoDetails)
                && todoTags.equals(toDo.todoTags) && deadline.equals(toDo.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, todoTitle, todoDetails, todoTags, deadline, reminder, complete);
    }
}
