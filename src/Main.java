import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

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
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements lists = doc.select("li.rootselection");
            for (Element list : lists) {
                System.out.println(list.select("h4").text());
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
