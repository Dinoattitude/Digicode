package com.example.digicode.vues;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digicode.R;
import com.example.digicode.utils.SqlHelper;

public class LoginActivity extends AppCompatActivity {

    private TextView mail;
    private TextView mdp;
    private Button btn;

    public SqlHelper sqlInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sqlInstance= new SqlHelper(this);

        btn = findViewById(R.id.btn_connect);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail= findViewById(R.id.edit_Mail);
                mdp= findViewById(R.id.edit_mdp);
                System.out.println(mail.getText()+" "+mdp.getText());
                boolean login = sqlInstance.isValidLogin(mail.getText().toString(), mdp.getText().toString());
                if(login){
                    Toast.makeText(v.getContext(),"Vos identifiants sont corrects", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                    Toast.makeText(v.getContext(),"Vos identifiants sont faux", Toast.LENGTH_SHORT).show();

            }
        });

    }
}