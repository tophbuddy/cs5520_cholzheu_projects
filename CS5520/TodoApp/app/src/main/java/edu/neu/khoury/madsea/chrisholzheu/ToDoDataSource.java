package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.neu.khoury.madsea.chrisholzheu.ToDoApp;

public final class ToDoDataSource implements IToDoDataSource{

    private ToDoDao toDoDao;

    public ToDoDataSource(Application application) {
        TodoRoomDatabase roomDatabase = TodoRoomDatabase.getDatabase(application);
        toDoDao = roomDatabase.toDoDao();
    }

    @Override
    public void insert(ToDo todo) {
        TodoRoomDatabase.databaseWriteExecutor.execute(() -> {
            toDoDao.insert(todo);
        });
    }

    @Override
    public void deleteAll() { }

    @Override
    public LiveData<List<ToDo>> getAllTodos() {
        return toDoDao.getAllToDos();
    }

    @Override
    public LiveData<List<ToDo>> getTodosLimited(int numToDos) {
        return toDoDao.getTodosLimited(numToDos);
    }
}
