package com.boss.courses;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.Adapters.RecyclerCourse1Adapter;
import com.boss.edutech.R;
import com.boss.edutech.databinding.ActivityEngineeringEntranceBinding;
import com.boss.edutech.databinding.ActivityMedicalEntranceBinding;
import com.boss.modelClass.CoursesModel;

import java.util.ArrayList;

public class MedicalEntrance extends AppCompatActivity {
    ActivityMedicalEntranceBinding binding;
    ArrayList<CoursesModel> coursesModels=new ArrayList<>();
    RecyclerCourse1Adapter recyclerCourse1Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMedicalEntranceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Medical Entrance ");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.toolbar.setTitle("Medical Entrance");

        coursesModels.add(new CoursesModel("Video",R.drawable.video));
        coursesModels.add(new CoursesModel("Study Material",R.drawable.material));
        coursesModels.add(new CoursesModel("Mock test",R.drawable.mocktest));
        coursesModels.add(new CoursesModel("Live Class",R.drawable.live_svgrepo_com));
        coursesModels.add(new CoursesModel("Need Help?",R.drawable.needhelp));
        coursesModels.add(new CoursesModel("performance",R.drawable.performance));
        binding.recuclerview.setAdapter(recyclerCourse1Adapter);
    }
}