package Functions;
import Models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Parse {
    private  ArrayList<Unit> units = new ArrayList<>();

    public Parse(File file) {
        try {
            // Iterates through each individual unit in the roster
            Document doc = Jsoup.parse(file, "UTF-8");
            displayListOfUnits(doc);
            Elements categories = trimCategories(doc);

            for (Element category : categories) {
                Elements allUnits = category.getElementsByClass("rootselection");
                for (Element unit : allUnits) {
                    // Creates new unit with its name parameter
                    Unit newUnit = new Unit(unit.select("h4").first().text());
                    // Adds any keywords associated with this unit
                    newUnit.setKeywords(unit.getElementsByClass("category-names").first().text());

                    // Get abilities and stats
                    Elements modelTables = unit.select("table");
                    for (Element table : modelTables) {
                        Elements rows = table.select("tr");
                        String columnData[];
                        int rowCount = rows.size() - 1;
                        int column = 0;
                        int columnCount;

                        // Abilities
                        if (rows.first().select("th:eq(0)").text().equals("Abilities")) {
                            columnCount = 3;
                            columnData = getColumnData(rows, columnCount);
                            Ability newAbilities[] = new Ability[rows.size() - 1];

                            for (int i = 0; i < rowCount; i++) {
                                Ability newAbility = new Ability(Arrays.copyOfRange(columnData, column, column + (columnCount - 1)));
                                column += columnCount;
                                newAbilities[i] = newAbility;
                            }
                            newUnit.setAbilities(newAbilities);
                        }
                        // Models.Unit stats
                        else if (rows.first().select("th:eq(0)").text().equals("Models.Unit")) {
                            columnCount = 11;
                            columnData = getColumnData(rows, columnCount);
                            Model newModels[] = new Model[rows.size() - 1];

                            for (int i = 0; i < rowCount; i++) {
                                Model newModel = new Model(Arrays.copyOfRange(columnData, column, column + (columnCount - 1)));
                                column += columnCount;
                                newModels[i] = newModel;
                            }
                            newUnit.setModels(newModels);
                        }
                        // Models.Weapon Stats
                        else if (rows.first().select("th:eq(0)").text().equals("Models.Weapon")) {
                            columnCount = 8;
                            columnData = getColumnData(rows, columnCount);
                            Weapon newWeapons[] = new Weapon[rows.size() - 1];

                            for (int i = 0; i < rowCount; i++) {
                                Weapon newWeapon = new Weapon(Arrays.copyOfRange(columnData, column, column + (columnCount - 1)));
                                column += columnCount;
                                newWeapons[i] = newWeapon;
                            }
                            newUnit.setWeapons(newWeapons);
                        }
                        // Wound Table
                        else if (rows.first().select("th:eq(0)").text().equals("Stat Damage - M/BS/A")) {
                            columnCount = 6;
                            columnData = getColumnData(rows, columnCount);
                            Vehicle newVehicles[] = new Vehicle[rows.size() - 1];

                            for (int i = 0; i < rowCount; i++) {
                                Vehicle newVehicle = new Vehicle(Arrays.copyOfRange(columnData, column, column + (columnCount - 1)));
                                column += columnCount;
                                newVehicles[i] = newVehicle;
                            }
                            newUnit.setVehicles(newVehicles);
                        }
                        // Rules
                    }
                    units.add(newUnit);
                    System.out.println();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a list of units within given file.
    public void displayListOfUnits(Document doc) {
        Elements lists = doc.select("li.rootselection");
        for (Element list : lists)
            System.out.println(list.select("h4").text());
        System.out.println();
    }

    // Removes any sections that do not contain units. (Doctrines, detachment rules, ect...)
    public Elements trimCategories(Document doc) {
        Elements categories = doc.getElementsByClass("category");

        for (int i = 0; i < categories.size(); i++)
            if (categories.get(i).select("h3").first().text().contains("No Force Org Slot"))
                categories.remove(i);

        return categories;
    }

    public String[] getColumnData(Elements rows, int columnCount) {
        String data[]= new String[(rows.size() - 1) * columnCount]; // Ignore header row (- 1)
        int index = 0;

        rows.next(); // Skip header row
        for (Element column : rows.select("td"))
            data[index++] = column.text();

        return data;
    }
}
