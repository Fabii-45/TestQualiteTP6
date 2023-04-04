package fr.miage.orleans.tq.exercice1.modele;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String motDePasse;
    private String email;
    private int id;
    private static int ID=0;


    public Utilisateur(String email,String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.id = ID++;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
