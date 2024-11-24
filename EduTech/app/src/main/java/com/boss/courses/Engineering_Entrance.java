package com.boss.courses;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.Adapters.RecyclerCourse1Adapter;
import com.boss.Adapters.RecyclerCourseAdapter;
import com.boss.edutech.R;
import com.boss.edutech.databinding.ActivityEngineeringEntranceBinding;
import com.boss.modelClass.CoursesModel;

import java.util.ArrayList;

public class Engineering_Entrance extends AppCompatActivity {
    ActivityEngineeringEntranceBinding binding;
    ArrayList<CoursesModel> coursesModels=new ArrayList<>();
    RecyclerCourse1Adapter recyclerCourse1Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityEngineeringEntranceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Engineering Entrance ");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.toolbar.setTitle("Engineering Entrance");

        coursesModels.add(new CoursesModel("Video",R.drawable.video));
        coursesModels.add(new CoursesModel("Study Material",R.drawable.material));
        coursesModels.add(new CoursesModel("Mock test",R.drawable.mocktest));
        coursesModels.add(new CoursesModel("Live Class",R.drawable.live_svgrepo_com));
        coursesModels.add(new CoursesModel("Need Help?",R.drawable.needhelp));
        coursesModels.add(new CoursesModel("performance",R.drawable.performance));
        recyclerCourse1Adapter = new RecyclerCourse1Adapter(this,coursesModels);
        binding.recuclerview.setAdapter(recyclerCourse1Adapter);
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