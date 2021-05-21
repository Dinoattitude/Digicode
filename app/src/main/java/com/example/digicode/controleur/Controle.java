package com.example.digicode.controleur;

import android.content.Context;
import android.util.Log;

import com.example.digicode.modele.Salle;
import com.example.digicode.utils.SqlHelper;

import java.util.Date;

public class Controle {

    private static final Controle instance = new Controle();
    private Salle salle;

    public static Controle getInstance() { return instance; }

    private Controle(){
        super();
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

}
