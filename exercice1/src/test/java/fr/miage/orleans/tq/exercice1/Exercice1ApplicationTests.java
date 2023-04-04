package fr.miage.orleans.tq.exercice1;
import fr.miage.orleans.tq.exercice1.modele.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class Exercice1ApplicationTests {

    // On mock la façade pour uniquement activer Springboot et le contrôleur que l'on teste
   @MockBean
    Facade facade;


   // Client qui permet d'exécuter des requêtes REST et de check des propriétés
   @Autowired
   MockMvc mockMvc;



}
