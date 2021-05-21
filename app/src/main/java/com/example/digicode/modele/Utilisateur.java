package com.example.digicode.modele;

public class Utilisateur {

    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Utilisateur(Integer p_id, String p_nom, String p_prenom, String p_mail, String p_mdp){
        this.setId(p_id);
        this.setNom(p_nom);
        this.setPrenom(p_prenom);
        this.setMail(p_mail);
        this.setMdp(p_mdp);
    }

}
