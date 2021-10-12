package edu.neu.khoury.madsea.chrisholzheu;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface IToDoDataSource {

    void insert(ToDo todo);

    void deleteAll();

    LiveData<List<ToDo>> getAllTodos();

    LiveData<List<ToDo>> getTodosLimited(int n);
}
