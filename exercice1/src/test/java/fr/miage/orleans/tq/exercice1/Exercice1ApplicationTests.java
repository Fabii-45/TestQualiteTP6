package fr.miage.orleans.tq.exercice1;
import fr.miage.orleans.tq.exercice1.controleur.Controleur;
import fr.miage.orleans.tq.exercice1.dtos.InscriptionDTO;
import fr.miage.orleans.tq.exercice1.modele.Facade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.nio.file.Paths;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class Exercice1ApplicationTests {

    // On mock la façade pour uniquement activer Springboot et le contrôleur que l'on teste
   @MockBean
    private Facade facade;

   // Client qui permet d'exécuter des requêtes REST et de check des propriétés
   @Autowired
   private MockMvc mockMvc;



}
