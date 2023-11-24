package com.example.carteautresor.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Case {
  int x;
  int y;
  CaseValeur caseValeur = CaseValeur.Vide;

  @Override
  public String toString() {
      return ".";
  }
}
