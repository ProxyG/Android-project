package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    List<Map<String, Object>> lstWeb = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String,Object>(){{
            put("question" , "Quel langage de balisage est principalement utilisé pour structurer le contenu d'une page web ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "JavaScript"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "CSS"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "HTML"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "PHP"); put("score" , 0);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Quel langage de programmation est couramment utilisé pour le développement côté serveur dans les applications web dynamiques ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "SQL"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Java"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Python"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "PHP"); put("score" , 1);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Quelle technologie est utilisée pour créer des styles et des mises en page élégantes sur un site web ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "JavaScript"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "HTML"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "CSS"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "XML"); put("score" , 0);}});
            put("answers", answers);
        }});
    }} ;
    List<Map<String, Object>> lstSecurity = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String,Object>(){{
            put("question" , "Que signifie l'acronyme \"VPN\" ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Virtual Private Network"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Très Personnel Notation"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Virtual Public Network"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Vaste Réseau Personnel"); put("score" , 0);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Quelle est la méthode courante utilisée dans les attaques d'ingénierie sociale pour manipuler les individus et leur faire révéler des informations sensibles ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Pare-feu"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Hameçonnage (Phishing)"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Antivirus"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Chiffrement"); put("score" , 0);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Laquelle des options suivantes décrit le mieux une attaque \"DDoS\" dans le contexte de la cybersécurité ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Destruction de données et Surchargement de sécurité"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Stockage de données distribué"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Déni de service (Denial of Service)"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Analyse approfondie des données"); put("score" , 0);}});
            put("answers", answers);
        }});
    }} ;
    List<Map<String, Object>> lstAI = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String,Object>(){{
            put("question" , "Quelle technique d'apprentissage automatique (machine learning) est utilisée pour regrouper des données non supervisées en groupes homogènes ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Régression linéaire"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Classification"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Clustering"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Réseau de neurones"); put("score" , 0);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Quel est l'objectif principal de l'apprentissage profond (deep learning) en IA ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Imiter le cerveau humain"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Résoudre des équations mathématiques complexes"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Automatiser les tâches répétitives"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Prédire le futur avec précision"); put("score" , 0);}});
            put("answers", answers);
        }});
        add(new HashMap<String,Object>(){{
            put("question" , "Quelle étape de l'apprentissage automatique (machine learning) implique l'utilisation de données étiquetées pour entraîner un modèle à faire des prédictions ?");
            List<Map<String, Object>> answers = new ArrayList<>();
            answers.add(new HashMap<String,Object>(){{put("answer" , "Prétraitement des données"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Entraînement du modèle"); put("score" , 1);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Évaluation du modèle"); put("score" , 0);}});
            answers.add(new HashMap<String,Object>(){{put("answer" , "Interprétation des résultats"); put("score" , 0);}});
            put("answers", answers);
        }});
    }} ;

    List<List<Map<String, Object>>> lst =new  ArrayList<List<Map<String, Object>>>(){{
        add(lstMobile);
        add(lstWeb);
        add(lstSecurity);
        add(lstAI);
    }};

    LinearLayout linearLayout;

    TextView textQuestion;

    ListView myAnswers;

    int index = 0;

    int score = 0;

    int position;
    public void updateScreen(){
        index++;
        if(index >= lst.get(position).size()){
            Intent i = new Intent(QuizActivity.this, ResultActivity.class);
            i.putExtra("score", (int) score);
            startActivity(i);

        }
        else{
            textQuestion.setText(lst.get(position).get(index).get("question").toString());
            myAnswers.setAdapter(new MyAdapter((List<Map<String, Object>>)lst.get(position).get(index).get("answers"), QuizActivity.this, this));
        }

    }

    public void updateScore(int answerScore){
        score+= answerScore;
        Log.d("LOG", String.valueOf(score));
    }




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz);

            position =  getIntent().getIntExtra("Position", 0);

            linearLayout = findViewById(R.id.myLayout);

            textQuestion = (TextView) findViewById(R.id.textQuestion);
            myAnswers = (ListView) findViewById(R.id.answers);

            textQuestion.setText(lst.get(position).get(index).get("question").toString());

            myAnswers.setAdapter(new MyAdapter((List<Map<String,Object>>)lst.get(position).get(index).get("answers"), QuizActivity.this, this));



        }

}