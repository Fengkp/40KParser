import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;

public class Main {

    static ArrayList<Unit> units = new ArrayList<>();
    static ArrayList<Ability> abilities = new ArrayList<>();
    static ArrayList<Model> models = new ArrayList<>();
    static ArrayList<Weapon> weapons = new ArrayList<>();

    public static void main(String[] args) {
        final File file = new File("files/test.html");
        try {
            // Lists all units
//            Document doc = Jsoup.parse(file, "UTF-8");
//            Elements lists = doc.select("li.rootselection");
//            for (Element list : lists) {
//                System.out.println(list.select("h4").text());
//            }
            // Iterates through each individual unit in the roster
            int count = 0;
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements allUnits = doc.getElementsByClass("rootselection");
            for (Element unit : allUnits) {
                // Skipping first one for now (Regiment/Doctrine/ect...)
                if (count == 0) {
                    count++;
                    continue;
                }

                // Creates new unit with its name parameter
                Unit newUnit = new Unit(unit.select("h4").first().text());
                // Adds any keywords associated with this unit
                newUnit.setKeywords(unit.getElementsByClass("category-names").first().text());

                // Get abilities and stats
                Elements modelTables = unit.select("table");
                for (Element table : modelTables) {
                    Elements rows = table.select("tr");

                    String columnData[];
                    int rowCount = 0;

                    // Abilities
                    if (rows.first().select("th:eq(0)").text().equals("Abilities")) {
                        columnData = getColumnData(rows, 3);
                        Ability newAbilities[] = new Ability[rows.size() - 1];

                        for (int i = 0; i < newAbilities.length; i++) {
                            Ability newAbility = new Ability(columnData[rowCount++], columnData[rowCount++]);
                            rowCount++; // Account for reference column.
                            newAbilities[i] = newAbility;
                        }
                        newUnit.setAbilities(newAbilities);
                    }
                    // Unit stats
                    else if (rows.first().select("th:eq(0)").text().equals("Unit")) {
                        columnData = getColumnData(rows, 11);
                        Model newModels[] = new Model[rows.size() - 1];

                        for (int i = 0; i < newModels.length; i++) {
                            Model newModel = new Model(columnData[rowCount++], columnData[rowCount++],
                                    columnData[rowCount++], columnData[rowCount++], columnData[rowCount++],
                                    columnData[rowCount++], columnData[rowCount++], columnData[rowCount++],
                                    columnData[rowCount++], columnData[rowCount++]);
                            rowCount++; // Account for reference column.
                            newModels[i] = newModel;
                        }
                        newUnit.setModels(newModels);
                    }
                    // Weapon Stats
                    else if (rows.first().select("th:eq(0)").text().equals("Weapon")) {
                        columnData = getColumnData(rows, 8);
                        Weapon newWeapons[] = new Weapon[rows.size() - 1];

                        for (int i = 0; i < newWeapons.length; i++) {
                            Weapon newWeapon = new Weapon(columnData[rowCount++], columnData[rowCount++],
                                    columnData[rowCount++], columnData[rowCount++], columnData[rowCount++],
                                    columnData[rowCount++], columnData[rowCount++]);
                            rowCount++; // Account for reference column.
                            newWeapons[i] = newWeapon;
                        }
                        newUnit.setWeapons(newWeapons);
                    }
                    else if (rows.first().select("th:eq(0)").text().equals("Stat Damage - M/BS/A")) {
                        columnData = getColumnData(rows, 6);
                        Vehicle newVehicles[] = new Vehicle[rows.size() - 1];

                        for (int i = 0; i < newVehicles.length; i++) {
                            Vehicle newVehicle = new Vehicle(columnData[rowCount++], columnData[rowCount++],
                                    columnData[rowCount++], columnData[rowCount++], columnData[rowCount++]);
                            rowCount++; // Account for reference column.
                            newVehicles[i] = newVehicle;
                        }
                        newUnit.setVehicles(newVehicles);
                    }
                }
                units.add(newUnit);
                newUnit.displayUnit();
                System.out.println("new entry");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String[] getColumnData(Elements rows, int columnCount) {
        String data[]= new String[(rows.size() - 1) * columnCount]; // Ignore header row (- 1)
        int index = 0;

        rows.next(); // Skip header row
        for (Element column : rows.select("td"))
            data[index++] = column.text();


        return data;
    }
}
