public class Ability extends Data {
    private String description;

    public Ability(String name, String description) {
        super.setName(name);
        this.description = description;
    }

    public String toString() {
        return super.getName() + ": " + description;
    }

}
