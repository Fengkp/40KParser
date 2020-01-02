import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final File file = new File("files/test.html");
        // This will get the tables within the html and print out any relevant data.
        // Still need to categorize.
        try {
//            Document doc = Jsoup.parse(file, "UTF-8");
//            Elements tables = doc.select("table");
//            for (Element table : tables) {
//                Elements rows = table.select("tr");
//                for (Element row : rows) {
//                    Elements cols = row.select("td");
//                    System.out.println(cols.text());
//                }
//            }
            // Lists all units
//            Document doc = Jsoup.parse(file, "UTF-8");
//            Elements lists = doc.select("li.rootselection");
//            for (Element list : lists) {
//                System.out.println(list.select("h4").text());
//            }
            ArrayList<Unit> units = new ArrayList<>();
            ArrayList<Ability> abilities = new ArrayList<>();
            ArrayList<ModelStats> models = new ArrayList<>();
            ArrayList<WeaponStats> weapons = new ArrayList<>();
            int count = 0;
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements categories = doc.getElementsByClass("rootselection");
            for (Element category : categories) {
                // Skipping first one for now.
                if (count == 0) {
                    count++;
                    continue;
                }

                Unit unit = new Unit(category.select("h4").first().text());
                unit.keywords = category.getElementsByClass("category-names").first().text();

                Elements modelTable = category.select("table");
                for (Element row : modelTable.select("tr")) {
                    System.out.println(row.select("th").text());
                    System.out.println(row.select("td.profile-name").text());
//                    System.out.println(row.select("td").text());
//                    System.out.println("new row");
                }

                units.add(unit);
                System.out.println("new entry");
            }

            for (Unit unit : units) {
                System.out.println(unit.name);
                System.out.println(unit.keywords);
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Increment through each one instead of using 'Elements',
        // get relevant tables (abilities, weapons, ect...)
        // then go to the next.
    }
}
