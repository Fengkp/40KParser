public class Unit extends Data {
    private Model models[];
    private Weapon weapons[];
    private Ability abilities[];
    private Vehicle vehicles[];
    private String keywords;

    public Unit() {}

    public Unit(String name) {
        super.setName(name);
        abilities = null;
        vehicles = null;
    }

    public Model[] getModels() {
        return models;
    }

    public void setModels(Model[] models) {
        this.models = models;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public Ability[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Ability[] abilities) {
        this.abilities = abilities;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void displayUnit() {
        System.out.println("Unit Name: " + super.getName());
        if (abilities != null) {
            System.out.println("Abilities: ");
            super.displayList(abilities);
        }
        if (vehicles != null) {
            System.out.println("Stat Damage: ");
            super.displayList(vehicles);
        }
        System.out.println("Models: ");
        super.displayList(models);
        System.out.println("Weapons: ");
        super.displayList(weapons);
        System.out.println("Keywords: " + keywords);

    }
}
