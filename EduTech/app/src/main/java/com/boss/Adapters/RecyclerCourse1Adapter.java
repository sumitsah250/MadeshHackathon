package com.boss.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.chat.Chat;
import com.boss.edutech.R;
import com.boss.edutech.databinding.CoursesRowBinding;
import com.boss.modelClass.CoursesModel;
import com.courseitem.MockTest;
import com.courseitem.pdfActivity;
import com.courseitem.videoActivity;

import java.util.ArrayList;

public class RecyclerCourse1Adapter extends RecyclerView.Adapter<RecyclerCourse1Adapter.ViewHolder> {
    private Context context;
    private ArrayList<CoursesModel> coursesModels;

    public RecyclerCourse1Adapter(Context context, ArrayList<CoursesModel> coursesModels) {
        this.context = context;
        this.coursesModels = coursesModels;
    }

    @NonNull
    @Override
    public RecyclerCourse1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_row,parent,false);
        return new RecyclerCourse1Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCourse1Adapter.ViewHolder holder, int position) {
        holder.binding.image.setImageResource(coursesModels.get(position).getImage());
        holder.binding.name.setText(coursesModels.get(position).getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(context, videoActivity.class);
                    break;
                case 1:
                    intent = new Intent(context, pdfActivity.class);
                    break;
                case 4:
                    intent = new Intent(context, Chat.class);
                    break;
                case 2:
                    intent = new Intent(context, MockTest.class);
                    break;
                default:
                    intent = new Intent(context, videoActivity.class);
                    break;
            }
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CoursesRowBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=CoursesRowBinding.bind(itemView);
        }
    }
}
