package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Map;

public class MyAdapter2 extends BaseAdapter {

    private MainActivity mainActivity;

    private List<String> categories;

    private LayoutInflater layInf;

    private Context c;

    public MyAdapter2(MainActivity mainActivity, List<String> categories, Context c) {
        this.mainActivity = mainActivity;
        this.layInf = LayoutInflater.from(c);
        this.categories = categories;
        this.c = c;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {return categories.get(position);}

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layInf.inflate(R.layout.grid_display_item, null);
        Button categorieButton = convertView.findViewById(R.id.categorieButton);
        categorieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        mainActivity.navigateToQuiz();
                        break;
                    case 1:
                        break;
                    case 2:
                        mainActivity.signOutUser();
                        break;
                    case 3:
                        break;
                }

            }
        });

        categorieButton.setText((String)getItem(position));
        return convertView;
    }
}
