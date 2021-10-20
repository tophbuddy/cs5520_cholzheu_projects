package edu.neu.khoury.madsea.chrisholzheu.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("SELECT * FROM todo_table")
    LiveData<List<ToDo>> getAllToDos();

    @Query("SELECT * FROM todo_table LIMIT :n")
    LiveData<List<ToDo>> getTodosLimited(int n);
}
