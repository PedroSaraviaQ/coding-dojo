public class Mammal {
    private int energyLevel = 100;

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
