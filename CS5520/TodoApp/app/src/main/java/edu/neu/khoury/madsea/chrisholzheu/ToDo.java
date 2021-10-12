package edu.neu.khoury.madsea.chrisholzheu;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(tableName = "todo_table")
public class ToDo {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "todo_id")
    private int todoId;

    @NonNull
    private String todoTitle;

    private String todoDetails;
    private LocalDateTime targetDate;
    private Set todoTags;

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

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public Set getTodoTags() {
        return todoTags;
    }

    public void setTodoTags(Set todoTags) {
        this.todoTags = todoTags;
    }
    public static ToDo createTodo(@NonNull String title, @NonNull String details) {
        ToDo todo = new ToDo();
        todo.setTodoTitle(title);
        todo.setTodoDetails(details);
        return todo;
    }
}
