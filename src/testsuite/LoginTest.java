package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htmp";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test//1
    public void userShouldLoginSuccessfullyWithValidCredentials() {

//     * Enter valid username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Jhon Wick3");


//     * Enter valid password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "JhonWick");

//     * Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

//      * Verify the ‘Accounts Overview’ text is display
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Accounts Overview')]"), "Accounts Overview");


//
    }

    @Test//2

    public void verifyTheErrorMessage() {

//   * Enter invalid username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Jhon");

//   * Enter invalid password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Jhon");


//   * Click on Login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));


//   * Verify the error message ‘The username and password could not be verified.’
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Accounts Overview')]"), "Accounts Overview");

    }

    @Test//3
    public void userShouldLogOutSuccessfully() {

//    * Enter valid username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Jhon Wick3");

//    * Enter valid password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "JhonWick");


//    * Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

//    * Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

//    * Verify the text ‘Customer Login’
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");

    }
    @After
    public void testDown() {
        closeBrowser();
    }
}
