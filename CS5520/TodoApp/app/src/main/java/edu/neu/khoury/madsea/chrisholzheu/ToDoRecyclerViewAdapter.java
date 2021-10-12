package edu.neu.khoury.madsea.chrisholzheu;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoViewBinding;

public class ToDoRecyclerViewAdapter extends ListAdapter<ToDo, TodoViewHolder> {
    protected ToDoRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<ToDo> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoViewHolder(TodoViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class  TodoDiff extends DiffUtil.ItemCallback<ToDo> {

        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getTodoTitle().equals(newItem.getTodoTitle());
        }
    }
}
