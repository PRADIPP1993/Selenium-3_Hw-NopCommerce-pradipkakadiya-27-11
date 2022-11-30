package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Click on Computer Menu.
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[1]")).click();

        //1.2 Click on Desktop
        driver.findElement(By.xpath("//ul[@class='sublist']/li[1]/a[1]")).click();

        //1.3 Select Sort By position "Name: Z to A"
        selectbyvisibleTextFormDropDown(By.name("products-orderby"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {


        //2.1 Click on Computer Menu.
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[1]")).click();

        //2.2 Click on Desktop
        driver.findElement(By.xpath("//ul[@class='sublist']/li[1]/a[1]")).click();

        //2.3 Select Sort By position "Name: A to Z"
        selectbyvisibleTextFormDropDown(By.name("products-orderby"), "Name: A to Z");

        //add to cart
        try {
            clickonElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        } catch (StaleElementReferenceException exception) {
            clickonElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        }


        //2.5 Verify the Text "Build your own computer"
        verifyText("Build your own computer", By.xpath("//h1[text()='Build your own computer']"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectbyvisibleTextFormDropDown(By.name("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
       // 2.7.Select "8GB [+$60.00]" using Select class.
        selectbyvisibleTextFormDropDown(By.name("product_attribute_2"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_5_10']")).click();
        driver.findElement(By.xpath("//input[@id='product_attribute_5_10']")).click();
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
        //2.11 Verify the price "$1,475.00"
        verifyText("$1,475.00", By.xpath("//span[text()='$1,475.00']"));
        // 2.12 Click on "ADD TO CARD" Button.
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        //After that close the bar clicking on the cross button.
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions1 = new Actions(driver);
        WebElement Shopping = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        actions1.moveToElement(Shopping).click().build().perform();
        //2.14 Click on "GO TO CART" button.
        driver.findElement(By.xpath(" //button[contains(text(),'Go to cart')]")).click();
        //2.15 Verify the message "Shopping cart"
        verifyText("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.cssSelector(".qty-input")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector(".qty-input")).sendKeys("2");
        driver.findElement(By.xpath("//button[@id='updatecart']")).click();
        //2.17 Verify the Total"$2,950.00"
        verifyText("$2,950.00", By.xpath("//form[@id='shopping-cart-form']/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span[1]/strong[1]"));
        //2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        //2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //2.21Click on “CHECKOUT AS GUEST”Tab
        // 2.22 Fill the all mandatory field
        driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();
        // 2.22 Fill the all mandatory field
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("pradip");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("kakadiya");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("ppradipkakadiya999@gmail.com");
        selectbyvisibleTextFormDropDown(By.xpath("//select[@name='BillingNewAddress.CountryId']"), "India");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("surat");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("111,xyz soc");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("395010");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9132505421");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[4]")).click();
        // 2.23 Click on “CONTINUE”
        driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
        //2.25 Click on “CONTINUE”
        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
        //2.26 Select Radio Button “Credit Card”
        driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
        //2.27 Select “Master card” From Select credit card dropdown
        selectbyvisibleTextFormDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //2.28 Fill all the details
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("prime Testing");
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("6764032004359978");
        selectbyvisibleTextFormDropDown(By.xpath("//select[@id='ExpireMonth']"), "11");
        selectbyvisibleTextFormDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("9132");
        // 2.29 Click on “CONTINUE”
        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/button")).click();

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Payment Method: Credit Card", By.xpath("//li[@class='payment-method']"));

        //2.32	Verify “Shipping Method” is “Next Day Air”
        verifyText("Shipping Method: Next Day Air", By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));

        //2.33	Verify Total is “$2,950.00”
        verifyText("$2,950.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));

        //2.34 Click on “CONFIRM”
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        //2.35 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//h1[text()='Thank you']"));
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //2.37 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));


    }

    @After
    public void setdown() {
        closeBrowser();
    }
}






