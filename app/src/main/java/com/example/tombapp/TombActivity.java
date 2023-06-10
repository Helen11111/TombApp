package com.example.tombapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tombapp.databinding.ActivityMainBinding;
import com.example.tombapp.databinding.ActivityTombBinding;

import java.util.Timer;
import java.util.TimerTask;

public class TombActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityTombBinding binding;

    private int score;
    private int progress;
    Timer timer;
    TimerTask task_timer;
    Integer time_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTombBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        score = 0;
        progress = 0;

        binding.btnTreasure1.setOnClickListener(this);
        binding.btnTreasure2.setOnClickListener(this);
        binding.btnTreasure3.setOnClickListener(this);
        binding.btnTreasure4.setOnClickListener(this);
        binding.btnTreasure5.setOnClickListener(this);
        binding.btnTreasure6.setOnClickListener(this);

        time_end = 0;

        find(score);
        task_timer = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time_end++;
                        binding.txtTimer.setText(time_end.toString());
                        if (time_end == 0) {
                            timer.cancel();
                            timer.purge();
                        }
                    }
                });

            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task_timer, 1000, 1000);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.btnTreasure1) {
            binding.progressBar.setProgress(progress += 5);
            binding.progressText.setText(String.valueOf(progress + " %"));
            view.setBackgroundColor(Color.YELLOW);
            find(score);
        }
        if (view == binding.btnTreasure2) {
            binding.progressBar.setProgress(progress += 10);
            binding.progressText.setText(String.valueOf(progress + " %"));
            view.setBackgroundColor(Color.YELLOW);
            find(score);
        }
        if (view == binding.btnTreasure3) {
            binding.progressBar.setProgress(progress += 15);
            binding.progressText.setText(String.valueOf(progress + " %"));
            view.setBackgroundColor(Color.YELLOW);
            find(score);
        }
        if (view == binding.btnTreasure4){
            binding.progressBar.setProgress(progress += 20);
            binding.progressText.setText(String.valueOf(progress + " %"));
            view.setBackgroundColor(Color.YELLOW);
            find(score);
        }
        if(view == binding.btnTreasure5){
            binding.progressBar.setProgress(progress += 25);
            binding.progressText.setText(String.valueOf(progress + " %"));
            view.setBackgroundColor(Color.YELLOW);
            find(score);
        }
        if(view == binding.btnTreasure6){
            binding.progressBar.setProgress(progress += 25);
            binding.progressText.setText(String.valueOf(progress + " %"));
            view.setBackgroundColor(Color.YELLOW);
            find(score);
        }
        view.setOnClickListener(null);
    }

    private void endTomb(){
        Toast.makeText(this, "Your time:  " + time_end + " seconds!", Toast.LENGTH_LONG).show();
        timer.cancel();
    }
    private void find(int n) {
        if (n == 6) {
            endTomb();
        } else {
            binding.txtHint.setText(Constants.TOMB_CONST[n]);
            score++;
        }
    }
}