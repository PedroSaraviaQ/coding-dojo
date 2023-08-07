package com.zookeper.rare;

import com.zookeper.mammal.Mammal;

public class Bat extends Mammal {
    public Bat() {
        super(300);
    }

    public void fly() {
        System.out.println("The bat is flying!");
        setEnergyLevel(getEnergyLevel() - 50);
    }

    public void eatHumans() {
        System.out.println("The bat is satisfied!");
        setEnergyLevel(getEnergyLevel() + 25);
    }

    public void attackTown() {
        System.out.println("The bat has attacked a town!");
        setEnergyLevel(getEnergyLevel() - 100);
    }
}
