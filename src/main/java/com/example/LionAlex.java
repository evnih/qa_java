package com.example;

import java.util.List;

public class LionAlex  extends Lion {

    public LionAlex(Predator predator) throws Exception {
        super("Самец", predator);
    }
    @Override
    public int getKittens() {
        return 0;
    }
    public List<String> getFriends() {
        return List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
    }
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}
