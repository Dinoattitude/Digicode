package com.example.digicode;

import android.content.Context;

import com.example.digicode.utils.Serializer;

import java.util.Date;

public class Controle {

    private static String filename = "saveSalle"; //nom du fichier de sauvegarde des salles qui sont réservés
    private Salle salle;

    public void createSalle(String nom, Date dateOccupation, Context context){
        salle = new Salle(nom, dateOccupation);
        Serializer.serialize(filename, salle, context);
    }

    public static Salle getSalle(Context context){
        Salle uneSalle = (Salle) Serializer.deSerialize(filename, context);
        return uneSalle;
    }
}
