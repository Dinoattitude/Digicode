package com.example.digicode.controleur;

import android.content.Context;
import android.util.Log;

import com.example.digicode.modele.Salle;
import com.example.digicode.utils.Serializer;

import java.util.Date;

public class Controle {

    private static final Controle instance = new Controle();
    private static String filename = "saveSalle"; //nom du fichier de sauvegarde des salles qui sont réservés
    private Salle salle;

    public static Controle getInstance() { return instance; }

    private Controle(){
        super();

        //Pour les tests
        setSalle(new Salle("Gruber", new java.util.Date()));
        Log.i("Salle", this.getSalle().toString());
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void createSalle(String nom, Date dateOccupation, Context context){
        salle = new Salle(nom, dateOccupation);
        Serializer.serialize(filename, salle, context);
    }

    public static Salle getSalle(Context context){
        Salle uneSalle = (Salle) Serializer.deSerialize(filename, context);
        return uneSalle;
    }
}
