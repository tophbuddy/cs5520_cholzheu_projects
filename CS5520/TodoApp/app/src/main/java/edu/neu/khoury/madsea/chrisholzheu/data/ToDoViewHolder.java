package edu.neu.khoury.madsea.chrisholzheu.data;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoItemViewBinding;


public class ToDoViewHolder extends RecyclerView.ViewHolder {
    public TodoItemViewBinding todoViewBinding;

    public ToDoViewHolder(TodoItemViewBinding binding) {
        super(binding.getRoot());
        this.todoViewBinding = binding;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {}
        });
    }

    public void bind(ToDo toDo) {
        todoViewBinding.setTodo(toDo);
        todoViewBinding.executePendingBindings();
    }
}
