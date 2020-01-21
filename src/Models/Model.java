package Models;

public class Model extends Data {
    private String movement;
    private String weaponSkill;
    private String ballisticSkill;
    private String strength;
    private String toughness;
    private String wounds;
    private String attacks;
    private String leadership;
    private String save;

    public Model(String[] data) {
        super.setName(data[0]);
        movement = data[1];
        weaponSkill = data[2];
        ballisticSkill = data[3];
        strength = data[4];
        toughness = data[5];
        wounds = data[6];
        attacks = data[7];
        leadership = data[8];
        save = data[9];
    }

    public String toString() {
        return super.getName() + ": " + movement + " " + ballisticSkill + " " + weaponSkill + " " + strength
                + " " + toughness + " " + wounds + " " + attacks + " " + leadership + " " + save;
    }
}
