package Models;

public class Weapon extends Data {
    private String range;
    private String type;
    private String strength;
    private String armourPenetration;
    private String damage;
    private String abilities;

    public Weapon(String[] data) {
        super.setName(data[0]);
        range = data[1];
        type = data[2];
        strength = data[3];
        armourPenetration = data[4];
        damage = data[5];
        abilities = data[6];
    }

    public String toString() {
        return super.getName() + ": " + range + " " + type + " " + strength + " " + armourPenetration
                + " " + damage + " " + abilities;
    }
}
