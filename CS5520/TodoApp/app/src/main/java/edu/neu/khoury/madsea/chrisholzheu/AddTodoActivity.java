package edu.neu.khoury.madsea.chrisholzheu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.time.LocalDateTime;

import edu.neu.khoury.madsea.chrisholzheu.databinding.ActivityAddTodoBinding;
import edu.neu.khoury.madsea.chrisholzheu.databinding.ActivitySetTimeBinding;

public class AddTodoActivity extends Fragment {

    private ActivityAddTodoBinding addTodoBinding;
    private ActivitySetTimeBinding activitySetTimeBinding;
    private ToDoViewModel viewModel;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addTodoBinding = ActivityAddTodoBinding.inflate(inflater, container, false);
        addTodoBinding.setLifecycleOwner(this);
        return addTodoBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ToDoViewModel.Factory factory = new ToDoViewModel.Factory(requireActivity().getApplication());

        viewModel = new ViewModelProvider(requireActivity(), factory).get(ToDoViewModel.class);
        addTodoBinding.setViewmodel(viewModel);
        addTodoBinding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTodoBinding.editTextTodoTitle.clearFocus();
                addTodoBinding.editTextTodoDetails.clearFocus();
                addTodoBinding.remindMeCheckbox.clearFocus();
                viewModel.saveToDo();
                NavHostFragment.findNavController(AddTodoActivity.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        addTodoBinding.deadlineEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDeadlineSetter(view);
            }
        });
        addTodoBinding.reminderEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showRemindMeDatePicker(view);
            }
        });

        addTodoBinding.remindMeCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                remindMeClicked(view);
            }
        });

        addTodoBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AddTodoActivity.this)
                        .navigate(R.id.action_SecondFragment_pop);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        addTodoBinding = null;
    }

    public void remindMeClicked(View v){
        addTodoBinding.editTextTodoTitle.clearFocus();
        addTodoBinding.editTextTodoDetails.clearFocus();
        addTodoBinding.remindMeCheckbox.clearFocus();
        viewModel.editToDo.getValue().setReminder(addTodoBinding.remindMeCheckbox.isChecked());
        addTodoBinding.reminderEditText.setEnabled(addTodoBinding.remindMeCheckbox.isChecked());
    }

    public void showDeadlineSetter(View v) {
        addTodoBinding.editTextTodoTitle.clearFocus();
        addTodoBinding.editTextTodoDetails.clearFocus();
        addTodoBinding.remindMeCheckbox.clearFocus();
        activitySetTimeBinding = ActivitySetTimeBinding
                .inflate(requireActivity()
                        .getLayoutInflater());
        final AlertDialog alertDialog = new AlertDialog.Builder(requireActivity()).create();

        LocalDateTime dateTime = viewModel.editToDo.getValue().getDeadline();

        activitySetTimeBinding.datePicker.updateDate(dateTime
                .getYear(),dateTime
                .getMonthValue()-1,dateTime
                .getDayOfMonth());
        activitySetTimeBinding.timePicker.setHour(dateTime.getHour());
        activitySetTimeBinding.timePicker.setMinute(dateTime.getMinute());

        activitySetTimeBinding.dateTimeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker datePicker = activitySetTimeBinding.datePicker;
                TimePicker timePicker = activitySetTimeBinding.timePicker;

                LocalDateTime dateTime = LocalDateTime.of(datePicker.getYear(),datePicker
                        .getMonth()+1,datePicker
                        .getDayOfMonth(),timePicker
                        .getHour(),timePicker
                        .getMinute());

                viewModel.editToDo.getValue().setDeadline(dateTime);
                viewModel.editToDo.setValue(viewModel.editToDo.getValue());

                alertDialog.dismiss();
            }});
        activitySetTimeBinding.dateTimeCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setView(activitySetTimeBinding.getRoot());
        alertDialog.show();
    }

    public void showRemindMeDatePicker(View v) {
        activitySetTimeBinding = ActivitySetTimeBinding.inflate(requireActivity().getLayoutInflater());
        //final View dialogView = View.inflate(requireActivity(), R.layout.date_time_picker, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(requireActivity()).create();
        LocalDateTime dateTime = viewModel.editToDo.getValue().getDeadline();
        activitySetTimeBinding.datePicker.updateDate(dateTime.getYear(),dateTime
                .getMonthValue()-1,dateTime
                .getDayOfMonth());
        activitySetTimeBinding.timePicker.setHour(dateTime.getHour());
        activitySetTimeBinding.timePicker.setMinute(dateTime.getMinute());

        activitySetTimeBinding.dateTimeSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker datePicker = activitySetTimeBinding.datePicker;
                TimePicker timePicker = activitySetTimeBinding.timePicker;
                LocalDateTime dateTime = LocalDateTime.of(datePicker.getYear(),datePicker
                        .getMonth()+1,datePicker
                        .getDayOfMonth(),timePicker
                        .getHour(),timePicker
                        .getMinute());
                viewModel.editToDo.getValue().setDeadline(dateTime);
                viewModel.editToDo.setValue(viewModel.editToDo.getValue());
                alertDialog.dismiss();
            }});
        activitySetTimeBinding.dateTimeCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setView(activitySetTimeBinding.getRoot());
        alertDialog.show();
    }
}