package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRepository;
import edu.neu.khoury.madsea.chrisholzheu.notifications.ToDoNotificationManager;

public class ToDoViewModel extends ViewModel {
    private static final String VIEW_TAG = "ToDoViewModel";
    private ToDoRepository repo;
    private final LiveData<List<ToDo>> toDoList;
    public MutableLiveData<ToDo> editToDo;
    private boolean editFlag;
    private WorkManager workManager;

    public ToDoViewModel(ToDoRepository repo, WorkManager workManager) {
        this.repo = repo;
        if (editToDo == null) {
            editToDo = new MutableLiveData<>();
            editToDo.setValue(new ToDo());
        }
        toDoList = repo.getAllToDos();
        this.workManager = workManager;
    }

    public void saveToDo() {
        if (editFlag) {
            repo.update(editToDo.getValue());
            if (editToDo.getValue().isReminder()) {
                createNotification(editToDo.getValue().getTodoId());
            }
        } else {
            if (editToDo.getValue().isReminder()) {
                createNotification(editToDo.getValue().getTodoId());
            }
            ToDo newToDo = new ToDo();
            Log.d(VIEW_TAG, "edit todo with id: " + Long.toString((editToDo.getValue().getTodoId())));
            newToDo.setTodoTitle(editToDo.getValue().getTodoTitle());
            newToDo.setTodoDetails(editToDo.getValue().getTodoDetails());
            newToDo.setTodoTags(editToDo.getValue().getTodoTags());
            newToDo.setDeadline(editToDo.getValue().getDeadline());
            newToDo.setReminder(editToDo.getValue().isReminder());
            newToDo.setReminderDate(editToDo.getValue().getReminderDate());
            newToDo.setTodoId(repo.getToDoId());
            newToDo.setTodoOrder(repo.getToDoId());
            newToDo.setComplete(editToDo.getValue().isComplete());
            newToDo.setLongitude(editToDo.getValue().getLongitude());
            newToDo.setLatitude(editToDo.getValue().getLatitude());
            Log.d(VIEW_TAG, "Adding new todo with id: " + Long.toString((newToDo.getTodoId())));
            Log.d(VIEW_TAG, "Adding new todo with order number: " + Long.toString((newToDo.getTodoOrder())));
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

    public void setReminder(boolean remindMe){
        editToDo.getValue().setReminder(remindMe);
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

    public void swapItems(long oldPos, long newPos) {
        Log.d(VIEW_TAG, "ViewModel old position: " + oldPos);
        Log.d(VIEW_TAG, "ViewModel new position: " + newPos);
        repo.swapItems(oldPos, newPos);
    }

    public void updateOrder() {
        Log.d(VIEW_TAG, "update order called");
        repo.updateListOrder();
    }

    public LiveData<ToDo> getTodo(long id) {
        return repo.getTodoById(id);
    }

    public void createNotification(long toDoId) {
        String outputDataTag = "outputDataTag_" + Long.toString(toDoId);
        LocalDateTime reminderDate = editToDo.getValue().getReminderDate();
        Long notificationDelayTime = reminderDate
                .toEpochSecond(ZoneOffset.UTC) - LocalDateTime.now()
                .toEpochSecond(ZoneOffset.UTC);
        workManager.cancelAllWorkByTag(outputDataTag);
        Log.d(VIEW_TAG, "num seconds = " + notificationDelayTime);
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(ToDoNotificationManager.class)
                .setInputData(setReminderInfo(toDoId))
                .setInitialDelay(notificationDelayTime, TimeUnit.SECONDS)
                .addTag(outputDataTag)
                .build();
        workManager.enqueue(workRequest);
    }

    public Data setReminderInfo(long toDoId) {
        Data.Builder builder = new Data.Builder();
        builder.putLong(Constants.TODO_ID, toDoId);
        builder.putString(Constants.TODO_TITLE, editToDo.getValue().getTodoTitle());
        builder.putString(Constants.TODO_DETAILS, editToDo.getValue().getTodoDetails());
        return builder.build();
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;
        private final ToDoRepository mRepository;
        private final WorkManager workManager;

        public Factory(@NonNull Application application) {
            mApplication = application;
            mRepository = ((ToDoApp) application).getRepository();
            workManager = ((ToDoApp) application).getWorkManager();
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ToDoViewModel(mRepository, workManager);
        }
    }
}

