package com.example.carteautresor.entity;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> getListeCaractères(String ligne) {
        return Arrays.stream(ligne.split("-")).map(String::trim).toList();
    }
}
