package com.example.carteautresor.entity;

public class Carte {

  public Case[][] cases;

  public Carte(int largeur, int hauteur) {
    cases = new Case[largeur][hauteur];
  }
}
