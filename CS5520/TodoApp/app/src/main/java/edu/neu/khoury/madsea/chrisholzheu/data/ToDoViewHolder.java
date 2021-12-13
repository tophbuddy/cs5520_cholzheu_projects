package edu.neu.khoury.madsea.chrisholzheu.data;

import android.graphics.Color;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.khoury.madsea.chrisholzheu.R;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoItemViewBinding;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.ItemTouchHelperViewHolder;


public class ToDoViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
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

    @Override
    public void onItemSelected() {
        itemView.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void onItemClear() {
        itemView.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.teal_200));
    }
}
