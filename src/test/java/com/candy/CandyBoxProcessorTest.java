package com.candy;

import com.candy.model.CandyBoxEntity;
import com.candy.processor.TsubakiProcessor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandyBoxProcessorTest {

    @InjectMocks
    private TsubakiProcessor tsubakiProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessTsubakiOrder() {
        // Définition des données d'entrée pour le test
        int quantiteDemandee = 20;

        // Supposons que le résultat attendu est une liste de CandyBox avec 4 bonbons dans chaque, contenant 2 couleurs (rouge et vert)
        List<CandyBoxEntity> expectedResult = List.of(
                createCandyBox(4, "rouge", "vert"),
                createCandyBox(4, "rouge", "vert"),
                createCandyBox(4, "rouge", "vert"),
                createCandyBox(4, "rouge", "vert"),
                createCandyBox(4, "rouge", "vert")
        );

        // Appeler la méthode à tester
        List<CandyBoxEntity> result = tsubakiProcessor.processTsubakiOrder(quantiteDemandee);

        // Vérifier que le résultat est conforme à ce qui est attendu
        assertEquals(expectedResult, result);
    }

    // Méthode utilitaire pour créer une CandyBox avec des couleurs spécifiées
    private CandyBoxEntity createCandyBox(int totalBonbons, String... colors) {
        CandyBoxEntity candyBox = new CandyBoxEntity();
        candyBox.setTotalBonbons(totalBonbons);
        candyBox.setColors(List.of(colors));
        return candyBox;
    }
}
