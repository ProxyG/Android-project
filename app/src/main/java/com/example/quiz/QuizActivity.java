package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    List<Map<String, Object>> lstMobile = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String,Object>(){{
            put("question" , "Quel langage de programmation utilisons nous dans l'ISI ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Flutter"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Kotlin"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Java"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Swift"); put("score" , 0);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Comment réferencer un élément présent dans un fichier XML ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "getViewById"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "findElementById"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "findViewById"); put("score" , 1);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Pour utiliser une ListView il faut:");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Adapter"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Controlleur"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Boucle"); put("score" , 0);}});
            put("answers", answers);
        }});
    }} ;





    LinearLayout linearLayout;

    TextView textQuestion;

    ListView myAnswers;

    ProgressBar progressBar;
    Timer timer;

    TextView timerTextView;

    int index = 0;

    int score = 0;

    private boolean isTimerRunning = false;
    private long startTime;
    private long remainingTime;

    private final long timeLimit = 10000;

    private Handler timerHandler = new Handler(Looper.getMainLooper());

    public void updateScreen(){
        index++;
        if(index >= lstMobile.size()){
            stopQuestionTimer();
            Intent i = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("score", score);
            i.putExtras(bundle);
            startActivity(i);

        }
        else{
            textQuestion.setText(lstMobile.get(index).get("question").toString());
            myAnswers.setAdapter(new MyAdapter((List<Map<String, Object>>)lstMobile.get(index).get("answers"), QuizActivity.this, this));
            stopQuestionTimer();
            timerTextView.setText(formatTime(timeLimit));
            startQuestionTimer(timeLimit);
        }

    }

    public void updateScore(int answerScore){
        score+= answerScore;
        Log.d("LOG", String.valueOf(score));
    }

    private void startQuestionTimer(final long originalTimeLimitMillis) {
        // Initialize the start time only if the timer is not running
        if (!isTimerRunning) {
            progressBar.setMax((int) 10000);
            progressBar.setProgress(progressBar.getMax());
            startTime = System.currentTimeMillis();
            isTimerRunning = true;
            remainingTime = originalTimeLimitMillis;
        }

        // Define the timer task
        Runnable timerRunnable = new Runnable() {
            @Override
            public void run() {
                final long timeLimitMillis = originalTimeLimitMillis;
                long elapsedTime = System.currentTimeMillis() - startTime;
                remainingTime = Math.max(timeLimitMillis - elapsedTime, 0);
                //Log.d("index", String.valueOf(index));
                //Log.d("Time",String.valueOf(remainingTime) );

                if (remainingTime <= 0) {
                    stopQuestionTimer();
                    updateScore(0);
                    updateScreen();
                } else {
                    progressBar.setProgress((int) remainingTime);
                    timerTextView.setText(formatTime(remainingTime));

                    // Post the task again after a short delay (e.g., 100 milliseconds)
                    timerHandler.postDelayed(this, 10);
                }
            }
        };

        // Post the initial timer task
        timerHandler.post(timerRunnable);
    }

    private void stopQuestionTimer() {
        // Cancel the timer task and mark the timer as not running
        timerHandler.removeCallbacksAndMessages(null);
        isTimerRunning = false;
    }

    private String formatTime(long millis) {
        int seconds = (int) (millis / 1000) % 60;
        int milliseconds = (int) millis % 1000;

        return String.format("%02d:%03d", seconds, milliseconds);
    }

    @Override
    protected void onStart() {
        super.onStart();
        stopQuestionTimer();
    }


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz);

            linearLayout = findViewById(R.id.myLayout);

            progressBar = findViewById(R.id.progressBar);

            timerTextView = findViewById(R.id.timerTextView);

            textQuestion = (TextView) findViewById(R.id.textQuestion);
            myAnswers = (ListView) findViewById(R.id.answers);

            textQuestion.setText(lstMobile.get(index).get("question").toString());

            myAnswers.setAdapter(new MyAdapter((List<Map<String, Object>>) lstMobile.get(index).get("answers"), QuizActivity.this, this));

            timerTextView.setText(formatTime(10000));

            startQuestionTimer(timeLimit);

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopQuestionTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopQuestionTimer();

    }

    @Override
    protected void onResume() {
        super.onResume();
        startQuestionTimer(remainingTime);
    }
}