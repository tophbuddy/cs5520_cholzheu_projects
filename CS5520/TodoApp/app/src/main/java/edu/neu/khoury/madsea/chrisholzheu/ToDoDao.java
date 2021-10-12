package edu.neu.khoury.madsea.chrisholzheu;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDo todo);

    @Query("DELETE FROM ToDo")
    void deleteAll();

    @Query("SELECT * FROM ToDo")
    LiveData<List<ToDo>> getAllTodos(int n);

    @Query("SELECT * FROM ToDo LIMIT :n")
    LiveData<List<ToDo>> getTodosLimited(int n);
}
