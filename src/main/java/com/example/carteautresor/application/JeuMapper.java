package com.example.carteautresor.application;

import com.example.carteautresor.entity.*;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JeuMapper {
  public static Jeu toJeu(List<String> jeuFichier) throws Exception {

    var premièreLigne = jeuFichier.get(0);
    var carte = CarteMapper.toCarte(premièreLigne);

    for (int indiceLigne = 1; indiceLigne < jeuFichier.size() - 1; indiceLigne++) {
      var ligne = jeuFichier.get(indiceLigne);
      var caractères = Utils.getListeCaractères(ligne);
      var premièreLettreDeLaLigne = caractères.get(0);
      var caseValeur = CaseValeur.valueOf(String.valueOf(premièreLettreDeLaLigne));
      var x = Integer.parseInt(caractères.get(1));
      var y = Integer.parseInt(caractères.get(2));

      if (caseValeur == CaseValeur.M) {
        carte.cases[x][y] = new CaseMur(x, y);
      } else if (caseValeur == CaseValeur.T) {
        var nombreTrésors = Integer.parseInt(caractères.get(3));
        carte.cases[x][y] = new CaseTresor(x, y, nombreTrésors);
      }
    }
    var aventurier = AventurierMapper.toAventurier(jeuFichier.get(jeuFichier.size() - 1));

    return new Jeu(carte, aventurier, 0);
  }
}
