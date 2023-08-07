package com.zookeper.mammal;

public class Mammal {
    private int energyLevel;

    public Mammal() {
        this(100);
    }

    public Mammal(int energy) {
        energyLevel = energy;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energy) {
        energyLevel = energy;
    }

    public int displayEnergy() {
        System.out.println(energyLevel);
        return energyLevel;
    }
}
