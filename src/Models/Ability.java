package Models;

public class Ability extends Data {
    private String description;

    public Ability(String name, String description) {
        super.setName(name);
        this.description = description;
    }

    public Ability(String[] data) {
        super.setName(data[0]);
        description = data[1];
    }

    public String toString() {
        return super.getName() + ": " + description;
    }

}
