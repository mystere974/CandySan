package com.candy.processor;

import com.candy.model.CandyBoxEntity;
import com.candy.model.CommandeEntity;
import com.candy.model.CouleurEntity;
import com.candy.model.ItemcandyboxEntity;
import com.candy.exception.CommandeNonAutoriseeException;
import com.candy.repository.CouleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;



@Component
public class AsagaoProcessor {

    private final CouleurRepository couleurRepository;

    @Autowired
    public AsagaoProcessor(CouleurRepository couleurRepository) {
        this.couleurRepository = couleurRepository;
    }

    public List<CandyBoxEntity> processCommande(CommandeEntity commande, int hour) {
        String candyTag = commande.getCandytagEntity().getCandytag();

        if (candyTag.equalsIgnoreCase("ASAGAO") && (hour < 6 || hour >= 12)) {
            throw new CommandeNonAutoriseeException("Les bonbons ASAGAO ne peuvent être commandés que le matin entre 6h et midi.");
        }


        // Algorithme pour la livraison par CandyBox
        List<CandyBoxEntity> candyBoxList = new ArrayList<>();
        CandyBoxEntity candyBox = new CandyBoxEntity();
        candyBoxList.add(candyBox);

        List<ItemcandyboxEntity> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ItemcandyboxEntity item = new ItemcandyboxEntity();
            item.setCouleurEntity(getCouleurAleatoire());
            items.add(item);
        }

        candyBox.setItemCandyBoxEntities(items);
        commande.setCandyBoxEntities(candyBoxList);

        return candyBoxList;
    }

    private CouleurEntity getCouleurAleatoire() {
        Random random = new Random();
        int index = random.nextInt(CouleurEntity.COULEURS.size());

        String couleurNomAleatoire = CouleurEntity.COULEURS.get(index);

        CouleurEntity couleurEntity = new CouleurEntity();
        couleurEntity.setCouleur(couleurNomAleatoire);

        return couleurEntity;
    }
}


