package com.example.digicode;

import java.io.Serializable;
import java.util.Date;

public class Salle implements Serializable {

    private String nom;
    private Date dateOccupation;

    public Salle (String s_nom, Date s_dateOccupation){
        this.nom = s_nom;
        this.dateOccupation = s_dateOccupation;
    }

}
