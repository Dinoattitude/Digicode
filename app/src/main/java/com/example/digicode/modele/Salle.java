package com.example.digicode.modele;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Salle implements Serializable {

    private String nom;
    private Date dateOccupation;

    public Salle (String s_nom, Date s_dateOccupation){
        this.nom = s_nom;
        this.dateOccupation = s_dateOccupation;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateOccupation() {
        return dateOccupation;
    }

    @Override
    public String toString(){ //Erreur sa mère whalla ç a ma saoulé : return null pour l'objet quand la date est pas selectionnée dans le calendrier
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = "";
        //On regarde si la date est null, si oui on met la date systeme, sinon on met la date de la salle)
        if(this.dateOccupation == null){
            selectedDate = sdf.format(new java.util.Date());
        }
        else{
            selectedDate = sdf.format(this.dateOccupation);
        }
        return this.nom + " " + selectedDate;
    }

}
