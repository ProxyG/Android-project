package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    GridView myGrid;

    TextView textQuestion;
    ProgressBar circularProgressBar;
    List<Map<String, Object>> lstMobile = new ArrayList<Map<String, Object>>();
    List<Map<String, Object>> answers = new ArrayList<>();

    List<String> categories = new ArrayList<String>() {{
        add("Quiz");
        add("Reset Quiz");
        add("Log out");
        add("Quit");
    }};

    public void navigateToQuiz(){
        Intent i = new Intent(MainActivity.this, QuizActivity.class);
        startActivity(i);

        //Use Bundle
    }

    public void signOutUser(){
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(MainActivity.this, SignInActivity.class);
        startActivity(i);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuestion = findViewById(R.id.textQuestion);

        myGrid = (GridView) findViewById(R.id.grid);

        myGrid.setAdapter(new MyAdapter2(this, categories, MainActivity.this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        circularProgressBar = findViewById(R.id.circularProgressBar);

        fetchQuestions();
    }

    private void fetchQuestions() {
        // Show the progress bar while fetching
        circularProgressBar.setVisibility(View.VISIBLE);

        // Execute AsyncTask or background thread for fetching questions
        new FetchQuestionsTask().execute();
    }

    private class FetchQuestionsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // Simulate fetching questions from the database
            // Perform your actual database operation here

            // For example, sleep for 3 seconds to simulate a time-consuming task
            try {
                // In your main activity or dedicated class

                QuizDbHelper dbHelper = new QuizDbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();

// Query for questions with difficulty level "medium"
                String query = "SELECT * FROM questions";
                Cursor questionCursor = db.rawQuery(query,new String[]{});

// Loop through each question
                while (questionCursor.moveToNext()) {
                    answers.clear();
                    @SuppressLint("Range") long questionId = questionCursor.getLong(questionCursor.getColumnIndex("question_id"));
                    @SuppressLint("Range") String questionText = questionCursor.getString(questionCursor.getColumnIndex("question_text"));

                    // Get answers for the current question
                    String answerQuery = "SELECT * FROM answers WHERE question_id = ?";
                    Cursor answerCursor = db.rawQuery(answerQuery, new String[]{String.valueOf(questionId)});

                    while (answerCursor.moveToNext()) {
                        @SuppressLint("Range") String answerText = answerCursor.getString(answerCursor.getColumnIndex("answer_text"));
                        @SuppressLint("Range") int score = answerCursor.getInt(answerCursor.getColumnIndex("score"));

                        answers.add(new HashMap<String,Object>(){{put("answer" , answerText); put("score" , score);}});
                    }

                    // Store question and answers for later use in your quiz
                    // ...
                    lstMobile.add(new HashMap<String,Object>(){{
                        put("question",questionText);
                        put("answers",answers);
                    }});
                }

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Hide the progress bar after fetching is complete
            circularProgressBar.setVisibility(View.GONE);

            // Update UI or perform any post-fetching operations

            // Show your normal UI elements
            showNormalUI();
        }
    }

    private void showNormalUI() {
        // Your code to show other UI elements
        // For example, make the TextView visible:
        textQuestion.setVisibility(View.VISIBLE);
        myGrid.setVisibility(View.VISIBLE);
    }
}