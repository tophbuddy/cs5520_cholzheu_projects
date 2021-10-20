package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRepository;

public class ToDoViewModel extends AndroidViewModel {
    private ToDoRepository repo;
    private final LiveData<List<ToDo>> toDoList;
    public MutableLiveData<ToDo> editToDo;
    private boolean editFlag;

    public ToDoViewModel(ToDoRepository repo) {
        this.repo = repo;
        if (editToDo == null) {
            editToDo = new MutableLiveData<>();
            editToDo.setValue(new ToDo());
        }
        toDoList = repo.getAllToDos();
    }

    public void saveToDo() {
        if (editFlag) {
            repo.update(editToDo.getValue());
        } else {
            ToDo newToDo = new ToDo();
            newToDo.setTodoTitle(editToDo.getValue().getTodoTitle());
            newToDo.setTodoDetails(editToDo.getValue().getTodoDetails());
            newToDo.setTodoTags(editToDo.getValue().getTodoTags());
            newToDo.setDeadline(editToDo.getValue().getDeadline());
            newToDo.setRemindMe(editToDo.getValue().isRemindMe());
            newToDo.setComplete(editToDo.getValue().isComplete());
            repo.addToDo(newToDo);
        }
    }

    public void setEditFlag(ToDo toDo) {
        editToDo.setValue(toDo);
        editFlag = true;
    }

    public void setAddingFlag() {
        editToDo.setValue(new ToDo());
        editFlag = false;
    }

    public void setEditRemindMe(boolean remindMe){
        editToDo.getValue().setRemindMe(remindMe);
        editToDo.setValue(editToDo.getValue());
    }

    public void updateToDo(ToDo toDo) {
        repo.update(toDo);
    }

    public void deleteToDo(ToDo toDo) {
        repo.delete(toDo);
    }

    public LiveData<List<ToDo>> getToDoList() {
        return toDoList;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;
        private final ToDoRepository mRepository;

        public Factory(@NonNull Application application) {
            mApplication = application;
            mRepository = ((ToDoApp) application).getRepository();
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ToDoViewModel(mRepository);
        }
    }
}

