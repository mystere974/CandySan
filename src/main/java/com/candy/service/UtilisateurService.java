package com.candy.service;

import com.candy.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }
}
