package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    GridView myGrid;

    List<String> categories = new ArrayList<String>() {{
        add("Mobile");
        add("Web");
        add("Security");
        add("AI");
    }};

    public void navigateToQuiz(int position){
        Intent i = new Intent(MainActivity.this, QuizActivity.class);
        i.putExtra("Position", position);
        Log.d("LOG", String.valueOf(position));
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGrid = (GridView) findViewById(R.id.grid);

        myGrid.setAdapter(new MyAdapter2(this, categories, MainActivity.this));
    }
}