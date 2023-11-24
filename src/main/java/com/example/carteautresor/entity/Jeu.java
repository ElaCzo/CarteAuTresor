package com.example.carteautresor.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Jeu {
  Carte carte;
  Aventurier aventurier;
  int nombreTrésorsRamassés;

  public void jouerTousLesTours() {
    while (aventurier.mouvements.size() > 0) jouerUnTour();
  }

  public void jouerUnTour() {
    var premierMouvement = aventurier.mouvements.get(0);
    aventurier.mouvements = aventurier.mouvements.subList(1, aventurier.mouvements.size());
    jouerMouvement(premierMouvement);
  }

  private void jouerMouvement(Mouvement premierMouvement) {
    if (premierMouvement.equals(Mouvement.Avancer)) {
      avancer();
    } else {
      tourner(premierMouvement);
    }
  }

  private void tourner(Mouvement mouvement) {
    if (mouvement.equals(Mouvement.TournerADroite)) {
      if (aventurier.orientation.equals(Orientation.O)) {
        aventurier.orientation = Orientation.N;
      } else if (aventurier.orientation.equals(Orientation.S)) {
        aventurier.orientation = Orientation.O;
      } else if (aventurier.orientation.equals(Orientation.E)) {
        aventurier.orientation = Orientation.S;
      } else if (aventurier.orientation.equals(Orientation.N)) {
        aventurier.orientation = Orientation.E;
      }
    } else if (mouvement.equals(Mouvement.TournerAGauche)) {
      if (aventurier.orientation.equals(Orientation.O)) {
        aventurier.orientation = Orientation.S;
      } else if (aventurier.orientation.equals(Orientation.S)) {
        aventurier.orientation = Orientation.E;
      } else if (aventurier.orientation.equals(Orientation.E)) {
        aventurier.orientation = Orientation.N;
      } else if (aventurier.orientation.equals(Orientation.N)) {
        aventurier.orientation = Orientation.O;
      }
    }
  }

  private void avancer() {
    if (aventurier.orientation.equals(Orientation.O)) {
      var caseDestination = carte.cases[aventurier.x - 1][aventurier.y];
      if (caseDestination != null) {
        if (!caseDestination.caseValeur.equals(CaseValeur.M)) {
          aventurier.x--;
        }
        if (caseDestination.caseValeur.equals(CaseValeur.T)) {
          if (((CaseTresor) caseDestination).ramasseTresor()) {
            nombreTrésorsRamassés++;
          }
        }
      } else {
        aventurier.x--;
      }
    } else if (aventurier.orientation.equals(Orientation.S)) {
      var caseDestination = carte.cases[aventurier.x][aventurier.y + 1];
      if (caseDestination != null) {
        if (!caseDestination.caseValeur.equals(CaseValeur.M)) {
          aventurier.y++;
        }
        if (caseDestination.caseValeur.equals(CaseValeur.T)) {
          if (((CaseTresor) caseDestination).ramasseTresor()) {
            nombreTrésorsRamassés++;
          }
        }
      } else {
        aventurier.y++;
      }
    } else if (aventurier.orientation.equals(Orientation.E)) {
      var caseDestination = carte.cases[aventurier.x + 1][aventurier.y];
      if (caseDestination != null) {
        if (!caseDestination.caseValeur.equals(CaseValeur.M)) {
          aventurier.x++;
        }
        if (caseDestination.caseValeur.equals(CaseValeur.T)) {
          if (((CaseTresor) caseDestination).ramasseTresor()) {
            nombreTrésorsRamassés++;
          }
        }
      } else {
        aventurier.x++;
      }
    } else if (aventurier.orientation.equals(Orientation.N)) {
      var caseDestination = carte.cases[aventurier.x][aventurier.y - 1];
      if (caseDestination != null) {
        if (!caseDestination.caseValeur.equals(CaseValeur.M)) {
          aventurier.y--;
        }
        if (caseDestination.caseValeur.equals(CaseValeur.T)) {
          if (((CaseTresor) caseDestination).ramasseTresor()) {
            nombreTrésorsRamassés++;
          }
        }
      } else {
        aventurier.y--;
      }
    }
  }

  public void afficherJeu() {
    for (var casesDuneLigne : carte.cases) {
      for (var case_ : casesDuneLigne) {
        System.out.println(" " + case_ + " ");
      }
      System.out.println();
    }
  }
}
