package edu.neu.khoury.madsea.chrisholzheu;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoViewBinding;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    public TodoViewBinding todoViewBinding;
    public TextView todoTitleView;

    public TodoViewHolder(TodoViewBinding binding) {
        super(binding.getRoot());
        this.todoViewBinding = binding;
    }

    public void bind(ToDo toDo) {
        todoViewBinding.setTodoDetails(toDo.getTodoDetails());
        todoViewBinding.setTodoTitle(toDo.getTodoTitle());
        todoViewBinding.setMTodo(toDo);
        todoViewBinding.executePendingBindings();
    }
}
