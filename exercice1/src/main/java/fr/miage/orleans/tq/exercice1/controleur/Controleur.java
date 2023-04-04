package fr.miage.orleans.tq.exercice1.controleur;


import fr.miage.orleans.tq.exercice1.dtos.InscriptionDTO;
import fr.miage.orleans.tq.exercice1.dtos.UtilisateurDTO;
import fr.miage.orleans.tq.exercice1.modele.EmailDejaPrisException;
import fr.miage.orleans.tq.exercice1.modele.Facade;
import fr.miage.orleans.tq.exercice1.modele.Utilisateur;
import fr.miage.orleans.tq.exercice1.modele.UtilisateurInexistantException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class Controleur {

    Facade facade;

    public Controleur(Facade facade) {
        this.facade = facade;
    }


    @PostMapping("/user")
    public ResponseEntity<String> enregistrer(@RequestBody InscriptionDTO inscriptionDTO) {
        try {

            int id = this.facade.inscription(inscriptionDTO.email(),inscriptionDTO.motDePasse());
            return ResponseEntity.created(URI.create("/api/user/"+id)).build();
        } catch (EmailDejaPrisException e) {
            return ResponseEntity.status(409).build();
        }
    }



    @GetMapping("/user/{id}")
    public ResponseEntity<UtilisateurDTO> getProfile(@PathVariable int id) {
        try {
            Utilisateur u = this.facade.getUtilisateurById(id);
            return ResponseEntity.ok(new UtilisateurDTO(u.getEmail(),u.getNom(),u.getPrenom()));
        } catch (UtilisateurInexistantException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUtilisateur(@PathVariable int id,@RequestBody UtilisateurDTO utilisateurDTO) {
        try {
            this.facade.update(id,utilisateurDTO.nom(),utilisateurDTO.prenom());
            return ResponseEntity.accepted().build();
        } catch (UtilisateurInexistantException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
