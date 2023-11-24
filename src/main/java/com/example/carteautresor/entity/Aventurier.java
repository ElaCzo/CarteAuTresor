package com.example.carteautresor.entity;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Aventurier {
  String nom;
  int x;
  int y;
  Orientation orientation;
  List<Mouvement> mouvements;
}
