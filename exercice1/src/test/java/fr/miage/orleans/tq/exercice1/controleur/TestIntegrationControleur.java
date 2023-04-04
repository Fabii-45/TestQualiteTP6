package fr.miage.orleans.tq.exercice1.controleur;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.orleans.tq.exercice1.dtos.InscriptionDTO;
import fr.miage.orleans.tq.exercice1.dtos.UtilisateurDTO;
import fr.miage.orleans.tq.exercice1.modele.FacadeImpl;
import fr.miage.orleans.tq.exercice1.modele.Utilisateur;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TestIntegrationControleur {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private FacadeImpl facade;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testEnregistrerOK() throws Exception{
        String email = "lalala.lalala@gmail.com";
        String password = "lalala";

        Utilisateur utilisateur = Mockito.mock(Utilisateur.class);
        given(utilisateur.getId()).willReturn(1);
        given(utilisateur.getEmail()).willReturn(email);
        given(utilisateur.getMotDePasse()).willReturn(password);

        given(facade.getUtilisateurById(utilisateur.getId())).willReturn(utilisateur);
        given(facade.inscription(email,password)).willReturn(1);

        InscriptionDTO inscriptionDTO = new InscriptionDTO(email,password);

        mvc.perform(post(URI.create("/api/user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inscriptionDTO)))
                .andExpect(status().isCreated());


    }

    @Test
    public void testEnregistrerEmailDejaPrisKO() throws Exception{
        String email = "lalala.lalala@gmail.com";
        String password = "lalala";

        Utilisateur utilisateur = Mockito.mock(Utilisateur.class);
        given(utilisateur.getId()).willReturn(1);
        given(utilisateur.getEmail()).willReturn(email);
        given(utilisateur.getMotDePasse()).willReturn(password);

        given(facade.getUtilisateurById(utilisateur.getId())).willReturn(utilisateur);
        given(facade.inscription(email,password)).willReturn(1);

        InscriptionDTO inscriptionDTO = new InscriptionDTO(email,password);

        mvc.perform(post(URI.create("/api/user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inscriptionDTO)))
                .andExpect(status().isCreated());

        mvc.perform(post(URI.create("/api/user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inscriptionDTO)))
                .andExpect(status().isConflict());
    }

    @Test
    public void testGetOK() throws Exception {
        //Définition des variables de retour de mock
        int idRetour = 1;
        String mailRetour = "charon.hugo@hotmail.com";
        String nomRetour = "CHARON";
        String passwordRetour = "password";

        //Création du retour de mock
        Utilisateur utilisateur = Mockito.mock(Utilisateur.class);
        given(utilisateur.getId()).willReturn(idRetour);
        given(utilisateur.getEmail()).willReturn(mailRetour);
        given(utilisateur.getNom()).willReturn(nomRetour);
        given(utilisateur.getMotDePasse()).willReturn(passwordRetour);

        given(facade.getUtilisateurById(idRetour)).willReturn(utilisateur);

        //On fait le json à retourner
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO(mailRetour, nomRetour, passwordRetour);

        //Vérification en passant
        mvc.perform(get(URI.create("/api/user/"+idRetour))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString().equals(objectMapper.writeValueAsString(utilisateurDTO));
    }









}
