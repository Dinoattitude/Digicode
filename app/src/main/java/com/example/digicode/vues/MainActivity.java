package com.example.digicode.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.digicode.R;
import com.example.digicode.controleur.Controle;
import com.example.digicode.modele.Salle;
import com.example.digicode.utils.SqlHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Controle ctrlInstance;
    public SqlHelper sqlInstance;


    private ListView mListView;
    private Button btnDigicode;
    private CalendarView calendarView;
    private ArrayList<String> salles;

    //Variables temporaires pour la position de la liste et de la date choisie
    private int numSalle = 0;
    private int moisChoisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context mContext = getApplicationContext();


        ctrlInstance = Controle.getInstance();
        sqlInstance= new SqlHelper(this);

        salles = sqlInstance.getSalles();

        mListView = (ListView) findViewById(R.id.Lv_salles);
        btnDigicode = findViewById(R.id.button);
        calendarView = findViewById(R.id.calendar);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_single_choice, salles);
        mListView.setAdapter(adapter2);

        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3){
                numSalle = position + 1;
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                moisChoisis = month;
            }
        });

        btnDigicode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),"Salle : " + mListView.getItemAtPosition(mListViewPosition),Toast.LENGTH_LONG).show();

                String digicode = "";
                digicode = String.valueOf(sqlInstance.recupDigicode(String.valueOf(moisChoisis),String.valueOf(numSalle)));
                Toast.makeText(getApplicationContext(), "Digicode : " + digicode, Toast.LENGTH_LONG).show();
            }
        });

    }


}