public class ModelStats extends Data {
    private String movement;
    private String weaponSkill;
    private String ballisticSkill;
    private String strength;
    private String toughness;
    private String wounds;
    private String attacks;
    private String leadership;
    private String save;

    public ModelStats() {}

    public void addElement(String data, int index) {
        switch (index) {
            case 0:
                super.setName(data);
                break;
            case 1:
                movement = data;
                break;
            case 2:
                weaponSkill = data;
                break;
            case 3:
                ballisticSkill = data;
                break;
            case 4:
                strength = data;
                break;
            case 5:
                toughness = data;
                break;
            case 6:
                wounds = data;
                break;
            case 7:
                attacks = data;
                break;
            case 8:
                leadership = data;
                break;
            case 9:
                save = data;
                break;
        }
    }

    public String toString() {
        return "Name: " + super.getName() + "\nMovement: " + movement;
    }
}
