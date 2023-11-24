package com.example.carteautresor.application;

import com.example.carteautresor.entity.Aventurier;
import com.example.carteautresor.entity.Mouvement;
import com.example.carteautresor.entity.Orientation;
import com.example.carteautresor.entity.Utils;

import java.util.ArrayList;

public class AventurierMapper {
  public static Aventurier toAventurier(String ligne) throws Exception {
    var caractères = Utils.getListeCaractères(ligne);
    if (!caractères.get(0).equals("A")) {
      throw new Exception();
    }
    var nom = caractères.get(1);
    var x = Integer.parseInt(caractères.get(2));
    var y = Integer.parseInt(caractères.get(3));
    var orientation = Orientation.valueOf(caractères.get(4));
    var trajet = caractères.get(5);
    var mouvements = new ArrayList<Mouvement>();
    for (var mouvement : trajet.toCharArray()) {
        switch (mouvement) {
            case 'A' -> mouvements.add(Mouvement.Avancer);
            case 'D' -> mouvements.add(Mouvement.TournerADroite);
            case 'G' -> mouvements.add(Mouvement.TournerAGauche);
        }
    }

    return new Aventurier(nom, x, y, orientation, mouvements);
  }
}
