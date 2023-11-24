package com.example.carteautresor.application;

import com.example.carteautresor.entity.Carte;
import com.example.carteautresor.entity.Utils;

import java.util.Arrays;
import java.util.List;

public class CarteMapper {
  public static Carte toCarte(String ligne) {
    var caractères = Utils.getListeCaractères(ligne);

    if (!caractères.get(0).equals("C")) {
      try {
        throw new Exception();

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    try {
      int x = Integer.parseInt(caractères.get(1));
      int y = Integer.parseInt(caractères.get(2));

      return new Carte(x, y);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
