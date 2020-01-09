import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    static ArrayList<Unit> units = new ArrayList<>();
    static ArrayList<Ability> abilities = new ArrayList<>();
    static ArrayList<ModelStats> models = new ArrayList<>();
    static ArrayList<WeaponStats> weapons = new ArrayList<>();

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
            Elements categories = doc.getElementsByClass("rootselection");
            for (Element category : categories) {
                // Skipping first one for now.
                if (count == 0) {
                    count++;
                    continue;
                }

                // Creates new unit with its name parameter
                Unit unit = new Unit(category.select("h4").first().text());
                // Adds any keywords associated with this unit
                unit.keywords = category.getElementsByClass("category-names").first().text();

                // Abilities
                Elements modelTable = category.select("table");
                for (Element table : modelTable) {
                    Elements rows = table.select("tr");
                    if (rows.first().select("th:eq(0)").text().equals("Abilities"))
                        addElements(rows, 2);
                    if (rows.first().select("th:eq(0)").text().equals("Unit"))
                        addElements(rows, 9);
                }

                units.add(unit);
                System.out.println("new entry");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addElements(String dataType, Elements rows, int columnCount) {
        rows.next();
        Elements columns = rows.select("td");
        if (dataType.equals("Abilities")) {
            Data newData = new Ability();
        }
        int columnIndex = 0;
        for (Element column : columns) {
            if (columnIndex != columnCount)
                newData.addElement(column.text(), columnIndex);
            else {
                abilities.add(newData);
                newData = new Ability();
                columnIndex = -1;
            }
            columnIndex++;
        }
    }
}
