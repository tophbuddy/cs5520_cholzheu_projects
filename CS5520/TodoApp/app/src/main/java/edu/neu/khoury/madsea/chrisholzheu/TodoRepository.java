package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

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

    public LiveData<List<ToDo>> getAllTodos() {
        return iToDoDataSource.getAllTodos();
    }

    public LiveData<List<ToDo>> getTodosLimited(int numTodos) {
        return iToDoDataSource.getTodosLimited(numTodos);
    }

    public void insertToDo(ToDo nToDo) {
        iToDoDataSource.insert(nToDo);
    }

    @NonNull
    @Override
    public Iterator<ToDo> iterator() {
        return iToDoDataSource.getAllTodos().getValue().iterator();
    }


    @Override
    public void forEach(@NonNull Consumer<? super ToDo> action) {
        iToDoDataSource.getAllTodos().getValue().forEach(action);
    }

    @NonNull
    @Override
    public Spliterator<ToDo> spliterator() {
        return iToDoDataSource.getAllTodos().getValue().spliterator();
    }
}
