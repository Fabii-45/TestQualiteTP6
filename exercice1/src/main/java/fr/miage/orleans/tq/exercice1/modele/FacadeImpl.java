package fr.miage.orleans.tq.exercice1.modele;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@Component
public class FacadeImpl implements Facade {
    Map<Integer,Utilisateur> personnes;


    public FacadeImpl() {
        this.personnes = new HashMap<>();
    }

    @Override
    public int inscription(String email, String mdp) throws EmailDejaPrisException {
        if (this.personnes.containsKey(email))
            throw new EmailDejaPrisException();
        else {
            Utilisateur utilisateur = new Utilisateur(email,mdp);
            this.personnes.put(utilisateur.getId(),utilisateur);
            return utilisateur.getId();
        }

    }

    @Override
    public void update(int id, String nom, String prenom) throws UtilisateurInexistantException {
        Utilisateur utilisateur = this.getUtilisateurById(id);
        if (Objects.nonNull(nom) && Objects.nonNull(prenom)) {
            if (!nom.isBlank()) {
                utilisateur.setNom(nom);
            }

            if (!prenom.isBlank()) {
                utilisateur.setPrenom(prenom);
            }
        }
    }

    @Override
    public Utilisateur getUtilisateurById(int id) throws UtilisateurInexistantException {
        Optional<Utilisateur> utilisateur = this.personnes.values().stream().filter(u -> u.getId()==id).findAny();
        if (utilisateur.isEmpty())
            throw new UtilisateurInexistantException();
        return utilisateur.get();
    }
}
