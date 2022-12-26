package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.QuickContactBadge;
import org.w3c.dom.Text;

public class Results extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    Button rstrtbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tv1 = (TextView)findViewById(R.id.correct_res);
        tv2 = (TextView)findViewById(R.id.wrong_res);
        tv3 = (TextView)findViewById(R.id.total_res);
        rstrtbtn = (Button) findViewById(R.id.button_restart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + Quiz.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + Quiz.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + Quiz.correct + "\n");
        tv1.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Quiz.correct=0;
        Quiz.wrong=0;

        rstrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }

}