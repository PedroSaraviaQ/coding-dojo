package com.zookeper.mammal;

public class Gorilla extends Mammal {
    public void throwSomething() {
        System.out.println("The gorilla has thrown something!");
        setEnergyLevel(getEnergyLevel() - 5);
    }

    public void eatBananas() {
        System.out.println("The gorilla is satisfied!");
        setEnergyLevel(getEnergyLevel() + 10);
    }

    public void climb() {
        System.out.println("The gorilla has climbed a tree!");
        setEnergyLevel(getEnergyLevel() - 10);
    }
}
