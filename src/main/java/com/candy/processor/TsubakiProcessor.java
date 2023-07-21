package com.candy.processor;

import com.candy.model.CandyBoxEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TsubakiProcessor {

    public static List<CandyBoxEntity> processTsubakiOrder(int quantiteDemandee) {
        if (quantiteDemandee <= 10 || quantiteDemandee % 2 != 0) {
            throw new IllegalArgumentException("La commande de bonbons Tsubaki n'est pas possible.");
        }

        List<CandyBoxEntity> candyBoxes = new ArrayList<>();
        int bonbonsParCandyBox = quantiteDemandee / 5;

        // Vérification des contraintes de répartition des couleurs
        while (!isColorsDistributionValid(bonbonsParCandyBox)) {
            bonbonsParCandyBox -= 2;
            if (bonbonsParCandyBox <= 0) {
                throw new IllegalArgumentException("La commande de bonbons Tsubaki n'est pas possible.");
            }
        }

        // Répartition des couleurs dans chaque CandyBox (Exemple avec 2 couleurs : "rouge" et "vert")
        int bonbonsParCouleur = bonbonsParCandyBox / 2;
        for (int i = 0; i < 5; i++) {
            CandyBoxEntity candyBox = new CandyBoxEntity();
            candyBox.setTotalBonbons(bonbonsParCandyBox);
            candyBox.setColors(Arrays.asList("rouge", "vert")); // Tu peux choisir d'autres couleurs ici
            candyBoxes.add(candyBox);
        }

        return candyBoxes;
    }


    // Vérifie si les contraintes de répartition des couleurs sont respectées dans une CandyBox
    private static boolean isColorsDistributionValid(int bonbonsParCandyBox) {
        int bonbonsParCouleur = bonbonsParCandyBox / 2;

        // Vérification des contraintes de répartition des couleurs dans une CandyBox
        return bonbonsParCandyBox % 2 == 0 && bonbonsParCandyBox >= 2 && bonbonsParCouleur % (bonbonsParCouleur / 2) == 0;
    }
}
