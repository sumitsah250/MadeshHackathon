package com.courseitem;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.Adapters.RecyclerViewCourseItem;
import com.boss.edutech.R;
import com.boss.edutech.databinding.ActivityVideoBinding;
import com.boss.modelClass.CoursesModel;

import java.util.ArrayList;

public class videoActivity extends AppCompatActivity {
    ActivityVideoBinding binding;
    ArrayList<CoursesModel> videoList=new ArrayList<>();
    RecyclerViewCourseItem recyclerViewCourseItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("VIDEO");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.toolbar.setTitle("VIDEO");

        videoList.add(new CoursesModel("# Lecture 1",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 2",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 3",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 4",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 5",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 6",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 7",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 8",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 9",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 10",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 11",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 12",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 13",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 14",R.drawable.play_svgrepo_com));
        videoList.add(new CoursesModel("# Lecture 15",R.drawable.play_svgrepo_com));

        recyclerViewCourseItem=new RecyclerViewCourseItem(this,videoList);
        binding.recyclerview.setAdapter(recyclerViewCourseItem);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button press
            onBackPressed(); // This will go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}