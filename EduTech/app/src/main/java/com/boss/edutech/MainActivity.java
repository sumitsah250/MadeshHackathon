package com.boss.edutech;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.Adapters.RecyclerCourseAdapter;
import com.boss.Adapters.RecyclerNoticeAdapter;
import com.boss.allBboutLogin.SignUpActivity;
import com.boss.courses.Engineering_Entrance;
import com.boss.edutech.databinding.ActivityMainBinding;
import com.boss.modelClass.CoursesModel;
import com.boss.modelClass.NoticeModel;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<SlideModel> imglist = new ArrayList<>();

    ArrayList<CoursesModel> coursesModels=new ArrayList<>();
    ArrayList<NoticeModel> noticeModels=new ArrayList<>();
    RecyclerCourseAdapter recyclerCourseAdapter;
    RecyclerNoticeAdapter recyclerNoticeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        startActivity(new Intent(this, Engineering_Entrance.class));
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("EduTech");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.toolbar.setTitle("EduTech");

        imglist.add(new SlideModel("https://mahilasanakisan.org.np/sms/cimage/cee.png", "Medical Examination Course ", ScaleTypes.FIT));
        imglist.add(new SlideModel("https://mahilasanakisan.org.np/sms/cimage/eng.png", "Engineering Entrance Course ", ScaleTypes.FIT));
        imglist.add(new SlideModel("https://mahilasanakisan.org.np/sms/cimage/web.png", "Web Development Course  ", ScaleTypes.FIT));
        binding.imageSlider.setImageList(imglist);
        //for adapter course and notice
        coursesModels.add(new CoursesModel("Engineering",R.drawable.engineering));
        coursesModels.add(new CoursesModel("Medical",R.drawable.medical));
        coursesModels.add(new CoursesModel("CMAT",R.drawable.cmat));
        coursesModels.add(new CoursesModel("ACCA",R.drawable.acca));
        recyclerCourseAdapter = new RecyclerCourseAdapter(this,coursesModels);
        binding.recyclerViewCourses.setAdapter(recyclerCourseAdapter);

        noticeModels.add((new NoticeModel("Engineering entrance date is out...","6:00 PM")));
        noticeModels.add((new NoticeModel("Medical Entrance exam will be published after a week","5:00 PM")));
        noticeModels.add((new NoticeModel("Cmat Entrance is at last step and the admission process will start soon...","6:00 AM")));
        noticeModels.add((new NoticeModel("All the student are requested to submit the form of the entrance of acca as soon as possible...","6:00 AM")));
        recyclerNoticeAdapter = new RecyclerNoticeAdapter(this,noticeModels);
        binding.recyclerViewNotice.setAdapter(recyclerNoticeAdapter);

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