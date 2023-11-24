package com.example.carteautresor.entity;

import lombok.AllArgsConstructor;
public class CaseMur extends Case {
    public CaseMur(int x, int y) {
        super(x, y, CaseValeur.M);
    }

    @Override
    public String toString() {
        return "M";
    }
}
