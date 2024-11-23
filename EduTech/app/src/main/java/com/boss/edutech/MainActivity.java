package com.boss.edutech;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.boss.allBboutLogin.SignUpActivity;
import com.boss.courses.Engineering_Entrance;
import com.boss.edutech.databinding.ActivityMainBinding;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<SlideModel> imglist = new ArrayList<>();

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
        startActivity(new Intent(this, Engineering_Entrance.class));
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

    }
}