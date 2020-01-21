package Models;

public class Vehicle extends Data {
    private String remainingWounds;
    private String movement;
    private String ballisticSkill;
    private String attacks;

    public Vehicle(String[] data) {
        super.setName(data[0]);
        this.remainingWounds = data[1];
        this.movement = data[2];
        this.ballisticSkill = data[3];
        this.attacks = data[4];
    }

    public String toString() {
        return super.getName() + ": " + remainingWounds + " " + movement + " " + ballisticSkill + " " + attacks;
    }

}
