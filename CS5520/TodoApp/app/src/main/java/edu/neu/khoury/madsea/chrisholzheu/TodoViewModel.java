package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    public MutableLiveData<String> todoDetails = new MutableLiveData<>();
    public MutableLiveData<String> todoTitle = new MutableLiveData<>();
    private MutableLiveData<Boolean> doesTodoExist = new MutableLiveData<>();
    private TodoRepository todoRepository;
    private final LiveData<List<ToDo>> curToDos;

    public TodoViewModel(Application application) {
        super(application);
        todoRepository = TodoRepository.getSingleton(application);
        if (todoTitle == null) {
            todoTitle = new MutableLiveData<>();
            todoTitle.setValue("");
        }
        if (todoDetails == null) {
            todoDetails = new MutableLiveData<>();
            todoDetails.setValue("");
        }
        curToDos = todoRepository.getTodosLimited(5);
        doesTodoExist.setValue(Boolean.FALSE);
    }

    public LiveData<Boolean> getDoesTodoExist() {
        return doesTodoExist;
    }

    public void addTodo() {
        todoRepository.insertToDo(ToDo.createTodo(todoTitle.getValue(), todoDetails.getValue()));
        doesTodoExist.setValue(Boolean.TRUE);
    }

    public LiveData<List<ToDo>> getCurToDos() {
        return curToDos;
    }
}

