package com.example;

import java.util.List;
import java.util.Objects;

public class Lion {
    private final Predator predator;
    private final Feline feline;

    private final boolean hasMane;

    public Lion(String sex, Predator predator, Feline feline) throws Exception {
        this.predator = Objects.requireNonNull(predator, "Predator не может быть null");
        this.feline = Objects.requireNonNull(feline, "Feline не может быть null");
        this.hasMane = setSex(sex);
    }

    public Lion(String sex, Predator predator) throws Exception {
        this(sex, predator, new Feline());
    }

    private boolean setSex(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            return true;
        } else if ("Самка".equals(sex)) {
            return false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
