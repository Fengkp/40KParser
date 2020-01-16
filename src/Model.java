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

    public Model(String name, String m, String wS, String bS, String s, String t, String w,
                 String a, String l, String sv) {
        super.setName(name);
        movement = m;
        weaponSkill = wS;
        ballisticSkill = bS;
        strength = s;
        toughness = t;
        wounds = w;
        attacks = a;
        leadership = l;
        save = sv;
    }

    public String toString() {
        return super.getName() + ": " + movement + " " + ballisticSkill + " " + weaponSkill + " " + strength
                + " " + toughness + " " + wounds + " " + attacks + " " + leadership + " " + save;
    }
}
