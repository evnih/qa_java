package com.example;

import java.util.List;
import java.util.Objects;

public class Lion {
    private final Feline feline;

    private final boolean hasMane;

    public Lion(String sex, Feline feline) throws Exception {
        this.feline = Objects.requireNonNull(feline, "Feline не может быть null");
        this.hasMane = setSex(sex);
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
        return feline.eatMeat();
    }
}
