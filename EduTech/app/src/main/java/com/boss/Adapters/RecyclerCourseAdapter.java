package com.boss.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.courses.Engineering_Entrance;
import com.boss.courses.MedicalEntrance;
import com.boss.edutech.R;
import com.boss.edutech.databinding.CoursesRowBinding;
import com.boss.modelClass.CoursesModel;
import com.courseitem.pdfActivity;
import com.courseitem.videoActivity;

import java.util.ArrayList;

public class RecyclerCourseAdapter extends RecyclerView.Adapter<RecyclerCourseAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CoursesModel> coursesModels;

    public RecyclerCourseAdapter(Context context, ArrayList<CoursesModel> coursesModels) {
        this.context = context;
        this.coursesModels = coursesModels;
    }

    @NonNull
    @Override
    public RecyclerCourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCourseAdapter.ViewHolder holder, int position) {
        // Pass the context to the getImage method to retrieve the Drawable
        holder.binding.image.setImageResource(coursesModels.get(position).getImage());
        holder.binding.name.setText(coursesModels.get(position).getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(context, Engineering_Entrance.class);
                    break;
                case 1:
                    intent = new Intent(context, MedicalEntrance.class);
                    break;
                default:
                    intent = new Intent(context, Engineering_Entrance.class);
                    break;
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CoursesRowBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=CoursesRowBinding.bind(itemView);
        }
    }
}
