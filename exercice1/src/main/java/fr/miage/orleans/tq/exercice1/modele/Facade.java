package fr.miage.orleans.tq.exercice1.modele;

public interface Facade {


    int inscription(String email, String mdp) throws EmailDejaPrisException;

    void update(int id, String nom, String prenom) throws UtilisateurInexistantException;

    Utilisateur getUtilisateurById(int id) throws UtilisateurInexistantException;
}
