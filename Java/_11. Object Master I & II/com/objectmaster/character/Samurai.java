package com.objectmaster.character;

import com.objectmaster.human.Human;

public class Samurai extends Human {
    public Samurai() {
        setHealth(200);
    }

    public void deathBlow(Human human) {
        human.setHealth(0);
        this.setHealth(this.getHealth() / 2);
    }

    public void meditate() {
        this.setHealth(this.getHealth() + this.getHealth() / 2);
    }
}
