package com.example.digicode.modele;

import java.util.ArrayList;

public class ConnectUtilisateur {
    static ArrayList<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();

    public static boolean verifUtilisateur(String mail, String mdp) {

        Utilisateur util1;
        Utilisateur util2;

        util1 = new Utilisateur(1, "Pointeau", "Adrien","adrien@gmail.com","azerty");
        util2 = new Utilisateur(2, "Laborde", "Marc","marc@gmail.com", "azerty");
        listUtilisateur.add(util1);
        listUtilisateur.add(util2);

        System.out.println(listUtilisateur.size());
        //ne rentre pas dans la boucle. A regler
        for (Utilisateur unUtilisateur : listUtilisateur) {
            if (mail.equals(unUtilisateur.getMail()) && mdp.equals(unUtilisateur.getMdp())) {
                System.out.println("ok");
                return true;
            }
        }
        return false;
    }

}
