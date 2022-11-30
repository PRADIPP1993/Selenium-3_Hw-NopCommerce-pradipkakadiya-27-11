package utilities;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickonElement(By by) {
        driver.findElement(by).click();
    }


    //**************************Method to verify element or text****************
    public void verifyText(String expectedMessage,By by){
        WebElement actualMessageText = driver.findElement(by);
        String actualMessage=actualMessageText.getText();
        Assert.assertEquals("Not as expected",actualMessage,expectedMessage);

    }

    public void selectbyvisibleTextFormDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }




}
