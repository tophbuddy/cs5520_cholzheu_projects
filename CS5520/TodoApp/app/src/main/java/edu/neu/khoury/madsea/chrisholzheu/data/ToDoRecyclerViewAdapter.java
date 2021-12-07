package edu.neu.khoury.madsea.chrisholzheu.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoItemViewBinding;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.ItemTouchHelperAdapter;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.OnStartDragListener;

public class ToDoRecyclerViewAdapter extends ListAdapter<ToDo, ToDoViewHolder>
        implements ItemTouchHelperAdapter {
    private ExternalOnClickListener clickListener;
    private OnStartDragListener dragListener;

    public ToDoRecyclerViewAdapter(Context context, ExternalOnClickListener onClickListener,
                                   OnStartDragListener onDragListener) {
        super(ToDo.toDoItemCallback);
        this.clickListener = onClickListener;
        this.dragListener = onDragListener;
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
        holder.todoViewBinding.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.toDoItemDeleteListener(getItem(holder.getLayoutPosition()));
            }
        });
//        holder.todoViewBinding..setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.onToDoCheckboxClick(getItem(holder.getLayoutPosition()), holder
//                        .todoViewBinding..isChecked());
//            }
//        });
    }

    @Override
    public boolean onItemMove(int startPos, int endPos) {
        return false;
    }

    @Override
    public void onItemDismiss(int pos) {

    }

    public interface ExternalOnClickListener {
        public void toDoItemClickListener(ToDo todo);
        public void toDoItemDeleteListener(ToDo toDo);
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
