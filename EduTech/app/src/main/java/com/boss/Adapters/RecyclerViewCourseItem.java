package com.boss.Adapters;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.edutech.R;
import com.boss.edutech.databinding.CourseitemrowBinding;
import com.boss.edutech.databinding.CoursesRowBinding;
import com.boss.modelClass.CoursesModel;
import com.courseitem.videoActivity;

import java.util.ArrayList;

public class RecyclerViewCourseItem extends RecyclerView.Adapter<RecyclerViewCourseItem.ViewHolder> {
    private Context context;
    private ArrayList<CoursesModel> coursesModels;
    public RecyclerViewCourseItem(Context context, ArrayList<CoursesModel> coursesModels) {
        this.context = context;
        this.coursesModels = coursesModels;
    }



    @NonNull
    @Override
    public RecyclerViewCourseItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courseitemrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCourseItem.ViewHolder holder, int position) {
        holder.binding.image.setImageResource(coursesModels.get(position).getImage());
        holder.binding.name.setText(coursesModels.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CourseitemrowBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= CourseitemrowBinding.bind(itemView);
        }
    }

}