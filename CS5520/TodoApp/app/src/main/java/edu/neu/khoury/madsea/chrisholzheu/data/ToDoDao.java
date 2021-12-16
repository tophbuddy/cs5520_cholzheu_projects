package edu.neu.khoury.madsea.chrisholzheu.data;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.google.android.gms.tasks.Task;

import java.util.List;

@Dao
public interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDo todo);

    @Update
    void update(ToDo toDo);

    @Delete
    void delete(ToDo toDo);

    @Query("DELETE FROM todo_table")
    void deleteAll();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateList(List<ToDo> toDoList);

    @Query("SELECT * FROM todo_table")
    LiveData<List<ToDo>> getAllToDos();

    @Query("SELECT MAX(todo_id) FROM todo_table")
    LiveData<Integer> getToDoId();

    @Query("UPDATE todo_table SET position_order = " +
            "( SELECT SUM(position_order) FROM todo_table WHERE todo_id IN (:oldPos, :newPos)) - " +
            "position_order WHERE todo_id IN (:oldPos, :newPos)")
    int swapPositions(long oldPos, long newPos);

    @Query("SELECT * FROM todo_table ORDER BY position_order ASC")
    LiveData<List<ToDo>> sortByOrder();

    @Query("SELECT MAX(position_order) FROM todo_table")
    LiveData<Integer> getLargestOrder();

    @Query("SELECT * FROM todo_table LIMIT :n")
    LiveData<List<ToDo>> getTodosLimited(long n);

    @Query("SELECT * FROM todo_table WHERE todo_table.todo_id == :todoId")
    LiveData<ToDo> getTodo(long todoId);
}
