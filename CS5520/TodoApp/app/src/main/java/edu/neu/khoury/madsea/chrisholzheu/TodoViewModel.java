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
    private final LiveData<List<ToDo>> mAllTodos;

    public TodoViewModel(Application application) {
        super(application);
        todoRepository = TodoRepository.getSingleton(application);
    }
}
