package com.objectmaster.character;

public class Character {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Ninja ninja = new Ninja();
        Samurai samurai = new Samurai();

        System.out.println(wizard.getHealth());
        System.out.println(ninja.getHealth());
        System.out.println(samurai.getHealth());

        wizard.heal(ninja);
        ninja.steal(wizard);
        samurai.meditate();

        System.out.println(wizard.getHealth());
        System.out.println(ninja.getHealth());
        System.out.println(samurai.getHealth());

        wizard.fireBall(ninja);
        ninja.runAway();
        samurai.deathBlow(wizard);

        System.out.println(wizard.getHealth());
        System.out.println(ninja.getHealth());
        System.out.println(samurai.getHealth());
    }
}
