package example.jackfan.mydatabindsample;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.jackfan.mydatabindsample.data.Task;
import example.jackfan.mydatabindsample.databinding.ListItemBinding;

/**
 * Created by jackf on 2016/4/19.
 */
public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder> {

    private List<Task> mTasks;

    public TaskRecyclerViewAdapter() {
        mTasks = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Task task = new Task("Test" + i, String.valueOf(i * 10));
            mTasks.add(task);
        }
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        //Log.d("Test", "onBindViewHolder " + position);
        holder.bind(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding mBinding;

        TaskViewHolder(View view) {
            super(view);
            mBinding = DataBindingUtil.bind(view);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("TaskViewHolder", "onClick--> position = " + getPosition());
//                }
//            });
        }

        public void bind(@NonNull Task task) {
            mBinding.setTask(task);
        }
    }
}
