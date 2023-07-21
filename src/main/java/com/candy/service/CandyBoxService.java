package com.candy.service;

import com.candy.model.CandyBoxEntity;
import com.candy.model.CommandeEntity;
import com.candy.processor.AsagaoProcessor;
import com.candy.processor.TsubakiProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandyBoxService {

    @Autowired
    private TsubakiProcessor tsubakiProcessor;

    @Autowired
    private AsagaoProcessor asagaoProcessor;

    public List<CandyBoxEntity> processCommande(CommandeEntity commande, int quantiteDemandee) {
        String candyTag = commande.getCandytagEntity().getCandytag();

        switch (candyTag) {
            case "Tsubaki":
                return tsubakiProcessor.processTsubakiOrder(quantiteDemandee);

            case "Asagao":
                return asagaoProcessor.processCommande(commande, 10);

            default:
                // Si aucun des cas ne correspond, vous pouvez gérer l'erreur ou renvoyer une liste vide par exemple
                return new ArrayList<>();
        }
        // Autres traitements si nécessaire...

    }


}
