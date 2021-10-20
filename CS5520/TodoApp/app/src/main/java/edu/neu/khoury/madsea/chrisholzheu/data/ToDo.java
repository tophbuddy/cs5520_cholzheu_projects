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
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "todo_id")
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

    @NonNull
    private boolean remindMe;

    @NonNull
    private boolean complete;

//    public ToDo(int todoId, @NonNull String todoTitle, @NonNull String todoDetails,
//                @NonNull Set<String> todoTags, @NonNull LocalDateTime deadline,
//                boolean remindMe, boolean complete) {
//        this.todoId = todoId;
//        this.todoTitle = todoTitle;
//        this.todoDetails = todoDetails;
//        this.todoTags = todoTags;
//        this.deadline = deadline;
//        this.remindMe = remindMe;
//        this.complete = complete;
//    }

    public ToDo(ToDo toDo) {
        setTodoId(toDo.getTodoId());
        setTodoTags(toDo.getTodoTags());
        setTodoTitle(toDo.getTodoTitle());
        setTodoDetails((toDo.getTodoDetails()));
        setDeadline(toDo.getDeadline());
        setRemindMe(toDo.isRemindMe());
        setComplete(toDo.isComplete());
    }

    public ToDo() {
        todoTitle = "";
        todoDetails = "";
        deadline = LocalDateTime.now();
        todoTags = new HashSet<String>();
        remindMe = false;
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

    public boolean isRemindMe() {
        return remindMe;
    }

    public void setRemindMe(boolean remindMe) {
        this.remindMe = remindMe;
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

    public Set getTodoTags() {
        return todoTags;
    }

    public void setTodoTags(Set todoTags) {
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
        return todoId == toDo.todoId && remindMe == toDo.remindMe && complete == toDo.complete
                && todoTitle.equals(toDo.todoTitle) && todoDetails.equals(toDo.todoDetails)
                && todoTags.equals(toDo.todoTags) && deadline.equals(toDo.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, todoTitle, todoDetails, todoTags, deadline, remindMe, complete);
    }


}
