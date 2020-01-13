import java.util.ArrayList;

public class Unit {
    String name;
    ArrayList<Model> stats;
    ArrayList<Weapon> weapons;
    ArrayList<Ability> abilities;
    String keywords;

    public Unit(String name) {
        this.name = name;
        stats = new ArrayList<>();
        weapons = new ArrayList<>();
        abilities = new ArrayList<>();
    }

    private void parseName() {
        // Get rid of bracket values in name
    }

}
