package com.courseitem;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.Adapters.RecyclerViewCourseItem;
import com.boss.Adapters.RecyclerViewCourseItem1;
import com.boss.edutech.R;
import com.boss.edutech.databinding.ActivityPdfBinding;
import com.boss.modelClass.CoursesModel;

import java.util.ArrayList;

public class pdfActivity extends AppCompatActivity {
    ActivityPdfBinding binding;
    ArrayList<CoursesModel> videoList=new ArrayList<>();

    RecyclerViewCourseItem1 recyclerViewCourseItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityPdfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("PDF");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.toolbar.setTitle("PDF");

        videoList.add(new CoursesModel("# Pdf 1",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 2",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 3",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 4",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 5",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 6",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 7",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 8",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 9",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 10",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 11",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 12",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 13",R.drawable.material));
        videoList.add(new CoursesModel("# Pdf 14",R.drawable.material));

        recyclerViewCourseItem=new RecyclerViewCourseItem1(this,videoList);
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