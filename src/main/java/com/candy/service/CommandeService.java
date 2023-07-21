package com.candy.service;

import com.candy.repository.CandyTagRepository;
import com.candy.repository.CommandeRepository;
import com.candy.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final CandyTagRepository candyTagRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository, UtilisateurRepository utilisateurRepository, CandyTagRepository candyTagRepository) {
        this.commandeRepository = commandeRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.candyTagRepository = candyTagRepository;


    }

//    public OrderResponse traiteCommande(CommandeRequest commandeRequest) {
//        // Vérifier l'existence de l'utilisateur
//        UtilisateurEntity utilisateur = utilisateurRepository.findById(commandeRequest.getIdUsers())
//                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Utilisateur non trouvé avec l'ID : " + commandeRequest.getIdUsers()));
//
//        // Vérifier l'existence du CandyTag
//        CandytagEntity candyTag = candyTagRepository.findByCandytag(commandeRequest.getCandytag())
//                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("CandyTag non trouvé : " + commandeRequest.getCandytag()));
//
//        // Créer une nouvelle commande
//        CommandeEntity nouvelleCommande = new CommandeEntity();
//        nouvelleCommande.setUtilisateurEntity(utilisateur);
//        nouvelleCommande.setCandytagEntity(candyTag);
//        nouvelleCommande.setQuantity(commandeRequest.());
//
//        // Enregistrer la commande en base de données
//        CommandeEntity commandeEnregistree = commandeRepository.save(nouvelleCommande);
//
//        // Créer la réponse
//        OrderResponse orderResponse = new OrderResponse();
//        orderResponse.setOrder(commandeEnregistree);
//        orderResponse.setMsgerr("");
//        orderResponse.setStatus(200);
//
//        return orderResponse;
//    }
}
