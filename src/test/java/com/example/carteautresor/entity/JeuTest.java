package com.example.carteautresor.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class JeuTest {

  @Test
  public void jouerUnTour() {
    var carte = new Carte(3, 4);
    carte.cases[1][0]=new CaseMur(1, 0);
    carte.cases[2][1]=new CaseMur(2, 1);
    carte.cases[0][3]=new CaseTresor(0, 3, 2);
    carte.cases[1][3]=new CaseTresor(1, 3, 3);
    var aventurier =
        new Aventurier(
            "Lara",
            1,
            1,
            Orientation.S,
            List.of(
                Mouvement.Avancer,
                Mouvement.Avancer,
                Mouvement.TournerADroite,
                Mouvement.Avancer,
                Mouvement.TournerADroite,
                Mouvement.Avancer,
                Mouvement.TournerAGauche,
                Mouvement.TournerAGauche,
                Mouvement.Avancer));
    var jeu = new Jeu(carte, aventurier, 0);
    jeu.jouerUnTour();
    assertThat(jeu).usingRecursiveComparison().isEqualTo(new Jeu(carte, new Aventurier(
            "Lara",
            1,
            2,
            Orientation.S,
            List.of(
                    Mouvement.Avancer,
                    Mouvement.TournerADroite,
                    Mouvement.Avancer,
                    Mouvement.TournerADroite,
                    Mouvement.Avancer,
                    Mouvement.TournerAGauche,
                    Mouvement.TournerAGauche,
                    Mouvement.Avancer)),0));
  }
  @Test
  public void jouerTousLesTours() {
    var carte = new Carte(3, 4);
    carte.cases[1][0]=new CaseMur(1, 0);
    carte.cases[2][1]=new CaseMur(2, 1);
    carte.cases[0][3]=new CaseTresor(0, 3, 2);
    carte.cases[1][3]=new CaseTresor(1, 3, 3);
    var aventurier =
            new Aventurier(
                    "Lara",
                    1,
                    1,
                    Orientation.S,
                    List.of(
                            Mouvement.Avancer,
                            Mouvement.Avancer,
                            Mouvement.TournerADroite,
                            Mouvement.Avancer,
                            Mouvement.TournerADroite,
                            Mouvement.Avancer,
                            Mouvement.TournerAGauche,
                            Mouvement.TournerAGauche,
                            Mouvement.Avancer));
    var jeu = new Jeu(carte, aventurier, 0);
    jeu.jouerTousLesTours();
    var carteFinale= new Carte(3, 4);
    carteFinale.cases[1][0]=new CaseMur(1, 0);
    carteFinale.cases[2][1]=new CaseMur(2, 1);
    carteFinale.cases[1][3]=new CaseTresor(1, 3, 2);
    assertThat(jeu).usingRecursiveComparison().isEqualTo(new Jeu(carte, new Aventurier(
            "Lara",
            0,
            3,
            Orientation.S,
            List.of()),3));
  }
}
