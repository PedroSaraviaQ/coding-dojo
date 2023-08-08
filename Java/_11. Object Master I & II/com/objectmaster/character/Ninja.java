package com.objectmaster.character;

import com.objectmaster.human.Human;

public class Ninja extends Human {
    public Ninja() {
        setStealth(10);
    }

    public void steal(Human human) {
        human.setHealth(human.getHealth() - this.getStealth());
        this.setHealth(this.getHealth() + this.getStealth());
    }

    public void runAway() {
        setHealth(getHealth() - 10);
    }
}
