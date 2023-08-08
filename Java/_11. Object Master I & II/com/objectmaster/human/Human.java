package com.objectmaster.human;

public class Human {
    private int strength = 3;
    private int intelligence = 3;
    private int stealth = 3;
    private int health = 100;

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStealth() {
        return stealth;
    }

    public int getHealth() {
        return health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Human human) {
        human.health -= this.strength;
    }
}
