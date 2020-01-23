package test;
import Functions.Parse;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void trimCategories_multipleElementTypes_returnOnlyH3() {
        List<Element> inputElements = new ArrayList<>();
        inputElements.add(new Element("<h3>Hello World!</h3>"));
        inputElements.add(new Element("<h1>Hello World!</h1>"));
        Elements test = Parse.trimCategories(new Elements(inputElements));
        Assert.assertTrue(test.size() == 1);
    }

    @org.junit.Test
    public void potatoes_plus_fries() {

    }
}
