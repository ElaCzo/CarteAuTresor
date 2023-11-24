package com.example.carteautresor.use_case;

import com.example.carteautresor.entity.Aventurier;
import com.example.carteautresor.entity.Carte;
import com.example.carteautresor.entity.Jeu;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JouerLaPartie {
  public void exécuter(Jeu jeu) {
    jeu.jouerTousLesTours();
    jeu.afficherJeu();
  }
}
