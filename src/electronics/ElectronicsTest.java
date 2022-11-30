package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement Electronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement Cellphones = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(Electronics).moveToElement(Cellphones).click().build().perform();
        verifyText("Cell phones", By.xpath("//div[@class='page-title']/h1"));
        driver.findElement(By.xpath("//a[contains(text(),'List')]")).click();
        try {
            clickonElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));
        } catch (StaleElementReferenceException exception) {
            clickonElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));
        }
        verifyText("Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        verifyText("$349.00", By.xpath("//span[@id='price-value-20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();
        verifyText("The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        driver.findElement(By.xpath("   //body/div[@id='bar-notification']/div[1]/span[1]")).click();
        Actions actions1 = new Actions(driver);
        WebElement Shopping = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        actions1.moveToElement(Shopping).click().build().perform();

        driver.findElement(By.xpath(" //button[contains(text(),'Go to cart')]")).click();
        verifyText("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //verifyText("2", By.xpath("//input[@id='itemquantity11219']"));
        verifyText("$698.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();

        driver.findElement(By.xpath("//input[@type='radio' and @value='M']")).click();

        driver.findElement(By.id("FirstName")).sendKeys("pradipkumar");

        driver.findElement(By.id("LastName")).sendKeys("kakadiya");


        driver.findElement(By.xpath("//option[@value='1']")).click();

        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[2]/option[2]")).click();

        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[3]/option[111]")).click();


        driver.findElement(By.id("Email")).sendKeys("ttriirrohanshha@gmail.com");

        driver.findElement(By.name("Password")).sendKeys("Pdd@1993@");

        driver.findElement(By.name("ConfirmPassword")).sendKeys("Pdd@1993@");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        verifyText("Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("pradip");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("kakadiya");


        selectbyvisibleTextFormDropDown(By.xpath("//select[@name='BillingNewAddress.CountryId']"), "India");

        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("surat");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("111,xyz soc");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("395010");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9132505421");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[4]")).click();
        verifyText("Shipping method", By.xpath("//h2[contains(text(),'Shipping method')]"));
        driver.findElement(By.xpath("//input[@id='shippingoption_2']")).click();
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")).click();
        verifyText("Payment method", By.xpath("//h2[contains(text(),'Payment method')]"));
        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
        driver.findElement(By.xpath(" //body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")).click();


        selectbyvisibleTextFormDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("prime Testing");
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("4111111111111111");
        selectbyvisibleTextFormDropDown(By.xpath("//select[@id='ExpireMonth']"), "11");
        selectbyvisibleTextFormDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("9132");
        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/button")).click();
        verifyText("$698.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        verifyText("Thank you", By.xpath("//h1[text()='Thank you']"));
        verifyText("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
        verifyText("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("verify url:", "https://demo.nopcommerce.com/", url);


    }

}
