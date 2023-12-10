package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final String TABLE_QUESTIONS = "questions";
    private static final String TABLE_ANSWERS = "answers";

    // Columns for questions table
    private static final String QUESTION_ID = "question_id";
    private static final String QUESTION_TEXT = "question_text";

    // Columns for answers table
    private static final String ANSWER_ID = "answer_id";
    private static final String QUESTION_ID_FK = "question_id";
    private static final String ANSWER_TEXT = "answer_text";
    private static final String SCORE = "score";

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create questions table
        String createQuestionsTableSql = "CREATE TABLE " + TABLE_QUESTIONS + "(" +
                QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                QUESTION_TEXT + " TEXT NOT NULL" +
                 ")";

        db.execSQL(createQuestionsTableSql);

        // Create answers table
        String createAnswersTableSql = "CREATE TABLE " + TABLE_ANSWERS + "(" +
                ANSWER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                QUESTION_ID_FK + " INTEGER NOT NULL," +
                ANSWER_TEXT + " TEXT NOT NULL," +
                SCORE + " INTEGER NOT NULL," +
                "FOREIGN KEY (" + QUESTION_ID_FK + ") REFERENCES " +
                TABLE_QUESTIONS + "(" + QUESTION_ID + "))";

        db.execSQL(createAnswersTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle schema changes
    }

    // Add a question and its answers
    public void addQuestion(String questionText, String[] answerTexts, int[] score) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues questionValues = new ContentValues();
        questionValues.put(QUESTION_TEXT, questionText);

        long questionId = db.insert(TABLE_QUESTIONS, null, questionValues);

        for (int i = 0; i < answerTexts.length; i++) {
            ContentValues answerValues = new ContentValues();
            answerValues.put(QUESTION_ID_FK, questionId);
            answerValues.put(ANSWER_TEXT, answerTexts[i]);
            answerValues.put(SCORE, score[i]);

            db.insert(TABLE_ANSWERS, null, answerValues);
        }
    }
}
