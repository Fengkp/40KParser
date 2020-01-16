public class Weapon extends Data {
    private String range;
    private String type;
    private String strength;
    private String armourPenetration;
    private String damage;
    private String abilities;

    public Weapon(String name, String r, String t, String s, String ap, String d, String a) {
        super.setName(name);
        range = r;
        type = t;
        strength = s;
        armourPenetration = ap;
        damage = d;
        abilities = a;
    }

    public String toString() {
        return super.getName() + ": " + range + " " + type + " " + strength + " " + armourPenetration
                + " " + damage + " " + abilities;
    }
}
