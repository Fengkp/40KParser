public class Weapon extends Data {
    String range;
    String type;
    String strength;
    String armourPenetration;
    String damage;
    String abilities;

    public Weapon(String name, String r, String t, String s, String ap, String d, String a) {
        super.setName(name);
        range = r;
        type = t;
        strength = s;
        armourPenetration = t;
        damage = d;
        abilities = a;
    }

    public String toString() {
        return "Name: " + super.getName() + "\nType: " + type;
    }
}
