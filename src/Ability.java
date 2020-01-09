public class Ability extends Data {
    private String description;

    public Ability() {}

    public String toString() {
        return "Ability: " + super.getName() + "\nDescription: " + description;
    }

    public void addElement(String data, int index) {
        switch (index) {
            case 0:
                super.setName(data);
                break;
            case 1:
                description = data;
                break;
        }
    }
}
