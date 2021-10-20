package edu.neu.khoury.madsea.chrisholzheu.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoItemViewBinding;

public class ToDoRecyclerViewAdapter extends ListAdapter<ToDo, ToDoViewHolder> {
//    private View.OnClickListener listener;
    private ExternalOnClickListener clickListener;
    public ToDoRecyclerViewAdapter(ExternalOnClickListener onClickListener) {
        super(ToDo.toDoItemCallback);
        this.clickListener = onClickListener;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(TodoItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        final int viewPosition = position;
        holder.bind(getCurrentList().get(viewPosition));
        holder.todoViewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.toDoItemClickListener(new ToDo(getItem(holder.getLayoutPosition())));
            }
        });
//        holder.todoViewBinding.checkBoxMarked.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onToDoCheckboxClick(getItem(holder.getLayoutPosition()), holder.todoViewBinding.doneCheckBox.isChecked());
//            }
//        });
    }

    public interface ExternalOnClickListener {
        public void toDoItemClickListener(ToDo todo);
    }

//    public static class TodoDiff extends DiffUtil.ItemCallback<ToDo> {
//
//        @Override
//        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
//            return oldItem == newItem;
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
//            return oldItem.getTodoTitle().equals(newItem.getTodoTitle());
//        }
//    }
}
