package com.example;

import java.util.List;

public class Lion {
    private final Predator predator;


    boolean hasMane;

    public Lion(String sex, Predator predator) throws Exception {
        this.predator = predator;
        this.feline = new Feline();
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    Feline feline = new Feline();

    public int getKittens() {
        return predator != null ? predator.getKittens() : feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator != null ? predator.eatMeat() : feline.getFood("Хищник");
    }
}
