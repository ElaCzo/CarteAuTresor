package com.example.carteautresor.entity;


public class CaseTresor extends Case {

  int nombreTrésors;
  public CaseTresor(int x, int y, int nombreTrésors) {
    super(x, y, CaseValeur.T);
    this.nombreTrésors=nombreTrésors;
  }

  public boolean ramasseTresor() {
    if (nombreTrésors > 0) {
      nombreTrésors--;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "T("+nombreTrésors+")";
  }
}
