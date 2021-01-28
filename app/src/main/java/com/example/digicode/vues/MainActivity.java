package com.example.digicode.vues;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Controle ctrlInstance;

    private ListView mListView;
    private Button btnDigicode;
    private CalendarView calendarView;
    private final String[] salles = new String[]{
            "Majorelle", "Gruber", "Lamour", "Longwy", "Daum", "Gallé", "Corbin", "Baccarat"
    };
    //Variables temporaires pour la position de la liste et de la date choisie
    private int mListViewPosition = 0;
    private Date mCalendarViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctrlInstance = Controle.getInstance();

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
                mListViewPosition = position;
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                mCalendarViewDate = c.getTime();
            }
        });

        btnDigicode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Salle : " + mListView.getItemAtPosition(mListViewPosition),Toast.LENGTH_LONG).show();

                createSalle();
                recupSalle();
            }
        });

    }

    private void createSalle(){
        //TODO Créer une salle ici
    }

    private void recupSalle(){
        Salle salle = (Salle) ctrlInstance.getSalle();
        Log.i("Salle Serializer",  salle.getNom() + " " + salle.getDateOccupation().toString());
    }


}