package com.zookeper.mammal;

public class GorillaTest {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();

        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.eatBananas();
        gorilla.climb();

        int energy = gorilla.displayEnergy();
    }
}
