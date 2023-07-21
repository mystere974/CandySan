package com.candy.controller;

import com.candy.model.CandyBoxEntity;
import com.candy.model.CommandeEntity;
import com.candy.service.CandyBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandyBoxController {

    @Autowired
    private final CandyBoxService candyBoxService;

    public CandyBoxController(CandyBoxService candyBoxService) {
        this.candyBoxService = candyBoxService;
    }

    @GetMapping("/commander")
    public List<CandyBoxEntity> commanderTsubaki(@RequestParam int qte, @RequestParam String candytag) {
        // Créer un objet CommandeEntity avec les paramètres reçus dans la requête
        CommandeEntity commande = new CommandeEntity();
        // Remplir l'objet commande avec les valeurs reçues dans la requête
        commande.setQuantity(qte);

        return candyBoxService.processCommande(commande, qte);
    }

}
