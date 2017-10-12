package com.aditya.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button g,ans1,ans2,ans3,ans4,playAgain;
    TextView timer,question,score,finalScore, result;
    CountDownTimer countDownTimer;
    boolean pressed = false, newques = false;
    int t = 0, f =0, sum = 0, correct,incorrect;
    public void clicked(View view)
    {
        String tag=view.getTag().toString();
        pressed = true;
        if(tag.equals("1"))
            t=1;
        else if(tag.equals("2"))
            t=2;
        else if(tag.equals("3"))
            t=3;
        else
            t=4;

    }

    public void go(View view)
    {

        f = 1;
        newques = true;
        correct = 0;
        incorrect = 0;
        score.setText(correct + "/" + incorrect);

        g.setVisibility(View.INVISIBLE);
        finalScore.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);

        ans1.setVisibility(View.VISIBLE);
        ans2.setVisibility(View.VISIBLE);
        ans3.setVisibility(View.VISIBLE);
        ans4.setVisibility(View.VISIBLE);
        if(f==1)
        {
            f=0;
            countDownTimer = new CountDownTimer(30000 + 100,1000){

                public void onTick(long milliSecUntilDone)
                {
                    int timeleft=(int)milliSecUntilDone/1000;
                    timer.setText(timeleft + " sec");

                    if(newques)
                    {
                        newques = false;
                        Random random = new Random();
                        int a = random.nextInt(21);
                        int b = random.nextInt(21);
                        sum = a+b;
                        question.setText(a + " + " + b);
                        result.setVisibility(View.INVISIBLE);


                        int ans = random.nextInt(5)+1;

                        ans1.setText(random.nextInt(41)+"");
                        ans2.setText(random.nextInt(41)+"");
                        ans3.setText(random.nextInt(41)+"");
                        ans4.setText(random.nextInt(41)+"");

                        if(ans == Integer.parseInt(ans1.getTag().toString()))
                            ans1.setText(sum+"");
                        else if(ans == Integer.parseInt(ans2.getTag().toString()))
                            ans2.setText(sum+"");
                        else if(ans == Integer.parseInt(ans3.getTag().toString()))
                            ans3.setText(sum+"");
                        else
                            ans4.setText(sum+"");



                    }

                    if(pressed)
                    {
                        pressed = false;
                        newques = true;
                        int response;

                        if(t==Integer.parseInt(ans1.getTag().toString()))
                            response = Integer.parseInt(ans1.getText().toString());
                        else if(t==Integer.parseInt(ans2.getTag().toString()))
                            response = Integer.parseInt(ans2.getText().toString());
                        else if(t==Integer.parseInt(ans3.getTag().toString()))
                            response = Integer.parseInt(ans3.getText().toString());
                        else
                            response = Integer.parseInt(ans4.getText().toString());

                        if(response == sum)
                        {
                            correct++;
                            result.setText("CORRECT");
                        }
                        else
                        {
                            incorrect++;
                            result.setText("INCORRECT");
                        }

                        score.setText(correct+"/"+incorrect);
                        result.setVisibility(View.VISIBLE);

                    }
                }
                public void onFinish()
                {
                    timer.setText("0 sec");
                    finalScore.setText("YOUR SCORE IS " + score.getText());
                    finalScore.setVisibility(View.VISIBLE);
                    playAgain.setText("Play Again");
                    playAgain.setVisibility(View.VISIBLE);
                }
            }.start();

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        g = (Button) findViewById(R.id.button);
        g.setVisibility(View.VISIBLE);

        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        ans4 = (Button) findViewById(R.id.ans4);
        playAgain = (Button) findViewById(R.id.playAgain);

        timer = (TextView) findViewById(R.id.timer);
        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);
        finalScore = (TextView) findViewById(R.id.finalScore);
        result = (TextView) findViewById(R.id.result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
