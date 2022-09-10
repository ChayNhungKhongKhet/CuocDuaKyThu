package com.phamtantb24.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton playBtn;
    RadioButton radioBtn1, radioBtn2, radioBtn3;
    SeekBar seekBar1, seekBar2, seekBar3;
    TextView textScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        CountDownTimer countDownTimer = new CountDownTimer(70000,300) {
            @Override
            public void onTick(long l) {
                if (seekBar1.getProgress() >= seekBar1.getMax()) {
                    score += radioBtn1.isChecked() ? 10 : -10;
                    textScore.setText(""+score);
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Frieza Win",Toast.LENGTH_LONG).show();
                    playBtn.setVisibility(View.VISIBLE);
                    EnableRadioBtn();
                }
                else if (seekBar2.getProgress() >= seekBar2.getMax()) {
                    score += radioBtn2.isChecked() ? 10 : -10;
                    textScore.setText(""+score);
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Goku Win",Toast.LENGTH_LONG).show();
                    playBtn.setVisibility(View.VISIBLE);
                    EnableRadioBtn();
                }
                else if(seekBar3.getProgress() >= seekBar3.getMax()) {
                    score += radioBtn1.isChecked() ? 10 : -10;
                    textScore.setText(""+score);
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Vegeta Win",Toast.LENGTH_LONG).show();
                    playBtn.setVisibility(View.VISIBLE);
                    EnableRadioBtn();
                }
                seekBar1.setProgress(seekBar1.getProgress() + new Random().nextInt(7));
                seekBar2.setProgress(seekBar2.getProgress() + new Random().nextInt(7));
                seekBar3.setProgress(seekBar3.getProgress() + new Random().nextInt(7));
            }

            @Override
            public void onFinish() {
            }
        };
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioBtn1.isChecked() ||  radioBtn2.isChecked() || radioBtn3.isChecked()) {
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);
                    countDownTimer.start();
                    playBtn.setVisibility(View.INVISIBLE);
                    DisableSeekBar();
                    DisableRadioBtn();
                    System.out.println(this);
                }
                else
                    Toast.makeText(MainActivity.this, "Please choose item for bet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DisableSeekBar() {
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
    }
    private void EnableRadioBtn() {
        radioBtn1.setEnabled(true);
        radioBtn2.setEnabled(true);
        radioBtn3.setEnabled(true);
    }
    private void DisableRadioBtn() {
        radioBtn1.setEnabled(false);
        radioBtn2.setEnabled(false);
        radioBtn3.setEnabled(false);
    }

    private void AnhXa() {
        playBtn = findViewById(R.id.playBtn);
        radioBtn1 = findViewById(R.id.radioBtn3);
        radioBtn2 = findViewById(R.id.radioBtn2);
        radioBtn3 = findViewById(R.id.radioBtn1);
        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        textScore = findViewById(R.id.textScore);
    }
}