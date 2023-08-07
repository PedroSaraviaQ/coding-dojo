package com.zookeper.rare;

public class BatTest {
    public static void main(String[] args) {
        Bat bat = new Bat();

        bat.attackTown();
        bat.attackTown();
        bat.attackTown();
        bat.eatHumans();
        bat.eatHumans();
        bat.fly();

        int energy = bat.displayEnergy();
    }
}
