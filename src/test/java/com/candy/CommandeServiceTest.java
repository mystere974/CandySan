package com.candy;


import com.candy.exception.CommandeNonAutoriseeException;
import com.candy.model.CandyBoxEntity;
import com.candy.model.CandyTagEntity;
import com.candy.model.CommandeEntity;
import com.candy.model.ItemcandyboxEntity;
import com.candy.repository.CouleurRepository;
import com.candy.processor.AsagaoProcessor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CommandeServiceTest {

    @Mock
    private CouleurRepository couleurRepository;

    @InjectMocks
    private AsagaoProcessor asagaoProcessor;

    @Test
    public void testLivraisonCandyBox() {
        // Créez une commande pour les bonbons Asago avec une quantité de bonbons élevée
        CommandeEntity commande = new CommandeEntity();
        CandyTagEntity candytagEntity = new CandyTagEntity();
        candytagEntity.setCandytag("Asagao");
        commande.setCandytagEntity(candytagEntity);
        int quantiteDemandee = 100; // Exemple avec 100 bonbons demandés

        LocalTime now = LocalTime.of(9, 0);

        // Appeler la méthode de traitement à l'heure actuelle
        List<CandyBoxEntity> result = asagaoProcessor.processCommande(commande, now.getHour());

        // Vérifier que chaque CandyBox contient au maximum 50 bonbons
        for (CandyBoxEntity candyBoxEntity : result) {
            int totalBonbonsDansCandyBox = 0;
            for (ItemcandyboxEntity itemCandyboxEntity : candyBoxEntity.getItemCandyBoxEntities()) {
                totalBonbonsDansCandyBox += itemCandyboxEntity.getQuantite();
            }
            assertTrue(totalBonbonsDansCandyBox <= 50);
        }
    }

    @Test
    public void testProcessCommandeNonAutorisee() {
        // Créer une commande non autorisée pour les bonbons "ASAGAO" en dehors de la plage horaire
        CommandeEntity commandeNonAutorisee = new CommandeEntity();
        CandyTagEntity candytagEntity = new CandyTagEntity();
        candytagEntity.setCandytag("ASAGAO");
        commandeNonAutorisee.setCandytagEntity(candytagEntity);

        // Changer l'heure pour simuler une commande en dehors de la plage horaire
        int heureHorsPlage = 9;
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(heureHorsPlage, 0));
        asagaoProcessor.processCommande(commandeNonAutorisee, 9);

        try {
            asagaoProcessor.processCommande(commandeNonAutorisee, dateTime.getHour());
            // Si aucune exception n'est lancée, c'est une erreur car cela signifie que la commande a été autorisée en dehors de la plage horaire
            fail("La commande a été autorisée en dehors de la plage horaire.");
        } catch (CommandeNonAutoriseeException e) {
            // Si une exception est lancée, c'est ce qu'on attend car la commande doit être non autorisée en dehors de la plage horaire
            assertEquals("Les bonbons ASAGAO ne peuvent être commandés que le matin entre 6h et midi.", e.getMessage());
        }
    }

}
