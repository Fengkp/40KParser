public class Vehicle extends Data {
    private String remainingWounds;
    private String movement;
    private String ballisticSkill;
    private String attacks;

    public Vehicle(String name, String remainingWounds, String movement, String ballisticSkill, String attacks) {
        super.setName(name);
        this.remainingWounds = remainingWounds;
        this.movement = movement;
        this.ballisticSkill = ballisticSkill;
        this.attacks = attacks;
    }

    public String toString() {
        return super.getName() + ": " + remainingWounds + " " + movement + " " + ballisticSkill + " " + attacks;
    }

}
