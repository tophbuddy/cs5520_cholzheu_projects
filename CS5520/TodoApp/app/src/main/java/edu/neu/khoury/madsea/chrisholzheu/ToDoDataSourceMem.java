package edu.neu.khoury.madsea.chrisholzheu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;

public class ToDoDataSourceMem implements IToDoDataSource{
    private MutableLiveData<List<ToDo>> toDoItems = new MutableLiveData<>();

    public ToDoDataSourceMem() {
        toDoItems.setValue(new ArrayList<ToDo>());
    }

    @Override
    public void insert(ToDo todo) {
        toDoItems.getValue().add(todo);
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public LiveData<List<ToDo>> getAllTodos() {
        return toDoItems;
    }

    @Override
    public LiveData<List<ToDo>> getTodosLimited(int n) {
        int numToDoItems = toDoItems.getValue().size();
        List<ToDo> sublist = toDoItems.getValue().subList(0, Math.min(n, numToDoItems));
        LiveData<List<ToDo>> liveData = new MutableLiveData<>(sublist);
        return liveData;
    }
}
