import Functions.Parse;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File path: ");
        //final File file = new File(scanner.next());
        final File file = new File("files/1.25kTau.html");
        //final File file = new File("files/test.html");
        try {
            Parse parse = new Parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
