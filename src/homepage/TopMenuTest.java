package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

//1. TopMenuTest Class
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {

        //1.2 This method should click on the menu whatever name is passed as parameter.
        //1.3 method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
        if (menu == "Computer") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a"));
            verifyText("Computers", By.xpath("//h1[contains(text(),'Computers')]"));

        } else if (menu == "Electronics") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
            verifyText("Electronics ", By.xpath("//h1[contains(text(),'Electronics')]"));

        } else if (menu == "Apparel") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[3]/a"));
            verifyText("Apparel ", By.xpath("//h1[contains(text(),'Apparel')]"));

        } else if (menu == "Digital downloads") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[4]/a"));
            verifyText("Digital downloads ", By.xpath("//h1[contains(text(),'Apparel')]"));

        } else if (menu == "Books") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[5]/a"));
            verifyText("Books ", By.xpath("//h1[contains(text(),'Books')]"));

        } else if (menu == "Jewelry") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[6]/a"));
            verifyText("Jewelry ", By.xpath("//h1[contains(text(),'Jewelry')]"));

        } else if (menu == "Gift Cards") {
            clickonElement(By.xpath("//div[@class='header-menu']/ul[1]/li[7]/a"));
            verifyText("Gift Cards ", By.xpath("//h1[contains(text(),'Gift Cards')]"));
        }
    }

    //1.3. create the @Test
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computer");

    }

    @After
    public void tearDown() {
        closeBrowser();

    }

}
