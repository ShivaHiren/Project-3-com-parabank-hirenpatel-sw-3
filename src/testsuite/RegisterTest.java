package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.io.Zip;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test//1

    public void verifyThatSigningUpPageDisplay() {

//  * click on the ‘Register’ link
    clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

//  * Verify the text ‘Signing up is easy!’
    verifyTextFromElements(By.xpath("//h1[contains(text(),'Signing up is easy!')]"),"Signing up is easy!");
    }

@Test//2
    public void userShouldRegisterAccountSuccessfully() {

//    *click on the ‘Register’link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

//    * Enter First name
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "Jhon");

//    *Enter Last name
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"), "Wick");

//    * Enter Address
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"),"1 London road");

//    * Enter City
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"),"London");

//    * Enter State
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"),"Westminister");

//    * Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"),"LL10LL");

//    *Enter Phone
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"),"0123456789");

//    *Enter SSN
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"),"123");

//    *Enter Username
        sendTextToElement(By.xpath("//input[@id='customer.username']"),"Jhon Wick5");

//    *Enter Password
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"JhonWick");

//    *Enter Confirm
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"),"JhonWick");


//    *Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

//   *Verify the text Your account was created successfully. You are now logged in.
        verifyTextFromElements(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"),"Your account was created successfully. You are now logged in.");

    }
    @After
    public void testDown() {
        closeBrowser();
    }
}
