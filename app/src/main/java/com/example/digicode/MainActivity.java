package com.example.digicode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Button btnDigicode;
    private final String[] salles = new String[]{
            "Majorelle", "Gruber", "Lamour", "Longwy", "Daum", "Gallé", "Corbin", "Baccarat"
    };
    private int mListViewPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.Lv_salles);
        btnDigicode = findViewById(R.id.button);

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

        btnDigicode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Salle : " + mListView.getItemAtPosition(mListViewPosition),Toast.LENGTH_LONG).show();
            }
        });

    }


}