package com.objectmaster.character;

import com.objectmaster.human.Human;

public class Wizard extends Human {
    public Wizard() {
        setHealth(50);
        setIntelligence(8);
    }

    public void heal(Human human) {
        human.setHealth(human.getHealth() + this.getIntelligence());
    }

    public void fireBall(Human human) {
        human.setHealth(human.getHealth() - 3 * this.getIntelligence());
    }
}
