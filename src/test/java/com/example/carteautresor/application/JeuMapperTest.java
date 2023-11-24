package com.example.carteautresor.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.carteautresor.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JeuMapperTest {
  @Test
  public void siFichierVide_alorsEchoue() {
    var fichier = new ArrayList<String>();
    assertThrows(Exception.class, () -> JeuMapper.toJeu(fichier));
  }

  @Test
  public void siFichierNonVideMaisAucuneLigneC_alorsEchoue() {
    var fichier = List.of("M - 1 - 1", "M - 2 - 2", "T - 0 - 3 - 2", "T - 1 - 3 - 1");
    assertThrows(Exception.class, () -> JeuMapper.toJeu(fichier));
  }

  @Test
  public void siFichierCorrect_alorsRéussit() throws Exception {
    var fichier =
        List.of(
            "C - 3 - 4",
            "M - 1 - 1",
            "M - 2 - 2",
            "T - 0 - 3 - 2",
            "T - 1 - 3 - 1",
            "A - Lara - 1 - 1 - S - AADADAGGA");
    var carte = new Carte(3, 4);
    carte.cases[1][1] = new CaseMur(1, 1);
    carte.cases[2][2] = new CaseMur(2, 2);
    carte.cases[0][3] = new CaseTresor(0, 3, 2);
    carte.cases[1][3] = new CaseTresor(1, 3, 1);
    assertThat(JeuMapper.toJeu(fichier))
        .usingRecursiveComparison()
        .isEqualTo(
            new Jeu(
                carte,
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
                        Mouvement.Avancer)), 0));
  }
}
