package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoRepository implements Iterable<ToDo>{
    private IToDoDataSource iToDoDataSource;
    private static TodoRepository singleton;

    private TodoRepository(Application application) {
        iToDoDataSource = new ToDoDataSource(application);

    }

    public static TodoRepository getSingleton(Application application) {
        if (singleton == null) {
            singleton = new TodoRepository(application);
        }
        return singleton;
    }

    public List<ToDo> asList() {
        return iToDoDataSource.getAllTodos().getValue();
    }

    public LiveData<List<ToDo>>

    public LiveData<List<ToDo>> getTodosLimited(int numTodos) {
        return iToDoDataSource.getTodosLimited(numTodos);
    }
}
