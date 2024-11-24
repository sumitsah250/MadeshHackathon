package com.boss.courses;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.boss.edutech.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class MocktestCreator extends AppCompatActivity {

    private TextView tvQuestion;
    private RadioGroup rgOptions;
    private Button btnNext;
    private BarChart barChart;

    private final String[] questions = {
            "What is the capital of France?",
            "What is 2 + 2?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Hamlet'?",
            "What is the square root of 16?"
    };

    private final String[][] options = {
            {"Paris", "Berlin", "Madrid", "Rome"},
            {"3", "4", "5", "6"},
            {"Earth", "Mars", "Venus", "Jupiter"},
            {"Shakespeare", "Dickens", "Austen", "Tolstoy"},
            {"2", "4", "6", "8"}
    };

    private final int[] correctAnswers = {0, 1, 1, 0, 1}; // Index of correct options
    private int currentQuestion = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocktest_creator);

        tvQuestion = findViewById(R.id.tvQuestion);
        rgOptions = findViewById(R.id.rgOptions);
        btnNext = findViewById(R.id.btnNext);
        barChart = findViewById(R.id.barChart);

        loadQuestion();

        btnNext.setOnClickListener(v -> {
            int selectedId = rgOptions.getCheckedRadioButtonId();
            if (selectedId != -1) { // Ensure an option is selected
                int selectedIndex = rgOptions.indexOfChild(findViewById(selectedId));
                if (selectedIndex == correctAnswers[currentQuestion]) {
                    score++;
                }
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {
                    showResult();
                }
            } else {
                // Show a message if no option is selected
                Toast.makeText(MocktestCreator.this, "Please select an option!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            tvQuestion.setText(questions[currentQuestion]); // Set the current question
            rgOptions.removeAllViews(); // Clear previous options

            for (int i = 0; i < options[currentQuestion].length; i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(options[currentQuestion][i]);
                rgOptions.addView(radioButton);
            }
        } else {
            showResult(); // In case loadQuestion is called at the end by mistake
        }
    }

    private void showResult() {
        tvQuestion.setVisibility(View.GONE);
        rgOptions.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);

        barChart.setVisibility(View.VISIBLE);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, score));
        entries.add(new BarEntry(1, questions.length - score));

        BarDataSet dataSet = new BarDataSet(entries, "Mock Test Result");
        BarData barData = new BarData(dataSet);
        barChart.setData(barData);

        String[] labels = {"Correct", "Incorrect"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);

        barChart.invalidate(); // Refresh chart
    }
}
