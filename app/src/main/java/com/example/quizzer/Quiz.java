package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    TextView tv;
    Button nq, quit;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?"
    };
    String answers[] = {"main method", "this", "public", "import pkg.*", "None of the mentioned"};
    String opt[] = {
            "finalize method", "main method", "static method", "private method",
            "import", "this", "catch", "abstract",
            "public", "protected", "private", "All of the mentioned",
            "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
            "int", "float", "void", "None of the mentioned"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.user_name);
        Intent intent = getIntent();
        String name=intent.getStringExtra("username");

        if (name.trim().equals(""))
            textView.setText("Hello Anonymous User");
        else
            textView.setText("Hello " + name);

        nq=(Button)findViewById(R.id.button3);
        quit=(Button)findViewById(R.id.button_quit);
        tv=(TextView) findViewById(R.id.textques);

        rg=(RadioGroup)findViewById(R.id.rd_btn_grp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        nq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rg.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score!=null)
                    score.setText(""+correct);


                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent result = new Intent(getApplicationContext(),Results.class);
                    startActivity(result);
                }
                rg.clearCheck();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_res=new Intent(getApplicationContext(),Results.class);
                startActivity(intent_res);
            }
        });
    }

}