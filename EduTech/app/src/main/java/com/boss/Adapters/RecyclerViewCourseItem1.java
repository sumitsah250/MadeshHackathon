package com.boss.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.courses.Engineering_Entrance;
import com.boss.edutech.R;
import com.boss.edutech.databinding.CourseitemrowBinding;
import com.boss.modelClass.CoursesModel;
import com.boss.pdfview.PdfView;
import com.boss.util.VideoViewer;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.ui.PdfActivity;

import java.util.ArrayList;

public class RecyclerViewCourseItem1 extends RecyclerView.Adapter<RecyclerViewCourseItem1.ViewHolder> {
    private Context context;
    private ArrayList<CoursesModel> coursesModels;
    public RecyclerViewCourseItem1(Context context, ArrayList<CoursesModel> coursesModels) {
        this.context = context;
        this.coursesModels = coursesModels;
    }

    @NonNull
    @Override
    public RecyclerViewCourseItem1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courseitemrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCourseItem1.ViewHolder holder, int position) {
        holder.binding.image.setImageResource(coursesModels.get(position).getImage());
        holder.binding.name.setText(coursesModels.get(position).getName());
        holder.binding.name.setTextSize(28);
        holder.itemView.setOnClickListener(v -> {

            switch (position) {
                case 0:
                    loadpdf("model");
                    break;
                case 1:
                    loadpdf("ent");
                default:
                    loadpdf("math");

                    break;
            }

        });

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
    private void loadpdf(String pdfName){
        final Uri uri = Uri.parse("file:///android_asset/"+pdfName+".pdf");
        final PdfActivityConfiguration config = new PdfActivityConfiguration.Builder(context).build();
        PdfActivity.showDocument(context, uri, config);
    }

}
