package com.example.quiz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    private QuizActivity quizActivity;

    private List<Map<String,Object>> answers;

    private LayoutInflater layInf;

    private Context c;

    public MyAdapter(List<Map<String,Object>> answers, Context c, QuizActivity quizActivity) {
        this.quizActivity = quizActivity;
        this.answers = answers;
        this.layInf = LayoutInflater.from(c);
        this.c = c;
    }

    @Override
    public int getCount() {
        return answers.size();
    }

    @Override
    public Object getItem(int position) {
        return answers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layInf.inflate(R.layout.button_display, null);
        Button answer = convertView.findViewById(R.id.answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizActivity.updateScore((int) answers.get(position).get("score"));
                quizActivity.updateScreen();
            }
        });
        answer.setText((String)answers.get(position).get("answer"));
        return convertView;
    }
}
