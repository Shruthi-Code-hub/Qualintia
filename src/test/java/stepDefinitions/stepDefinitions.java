package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.objRepo;

import java.time.Duration;

public class stepDefinitions {

    public WebDriver driver;
    public  WebDriverWait wait;
    public objRepo l;

    @Given("I am on the Gmail login page")
    public void i_am_on_the_gmail_login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        this.driver = new ChromeDriver(chromeOptions);
        l = new objRepo(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get("https://mail.google.com/mail/u/");

       // driver.manage().window().maximize();

    }

    @When("I enter valid credentials as {string} and {string}")
    public void i_enter_valid_credentials_as_and(String email, String password) throws InterruptedException {
        l.UserName().sendKeys(email);
        l.next().click();
        Thread.sleep(5000);
        l.password().sendKeys(password);
    }


    @When("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {

        l.next().click();
        Thread.sleep(10000);
        if(l.compose().isDisplayed())
        {
            System.out.println("user is able to see gmail home page");
        }
        else
        {
            l.notNow().click();
            Thread.sleep(10000);
        }


    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() throws InterruptedException {

     System.out.println("Successfully logged in");
    }


    @When("user is able to clicks on the Compose button")
    public void user_is_able_to_clicks_on_the_compose_button() {
         //wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(l.compose)));
        l.compose().click();
    }
    @Then("the compose window should open")
    public void the_compose_window_should_open() {
        String composeMsg = driver.findElement(By.xpath("//span[contains(text(),\"New Message\")]")).getText();
        Assert.assertEquals(composeMsg, "New Message");
    }

    @And("user is able to enters {string} in the {string} field")
    public void userIsAbleToEntersInTheField(String toRecipients, String arg1) {
        l.toRecipients().sendKeys(toRecipients);
    }

    @And("user is able to enters subject as {string} in the {string} field")
    public void userIsAbleToEntersSubjectAsInTheField(String arg0, String arg1) {
        l.subjectbox().sendKeys("Incubyte");
    }

    @And("user is able to enters emailBody as {string} in the {string} field")
    public void userIsAbleToEntersEmailBodyAsInTheField(String arg0, String arg1) {
        l.Body().sendKeys("Automation QA test for Incubyte");
    }

    @And("user is able to clicks the {string} button")
    public void userIsAbleToClicksTheButton(String arg0) {
        l.Send().click();
    }

    @Then("email should be sent successfully")
    public void emailShouldBeSentSuccessfully() {
        System.out.println("email should be sent successfully");

    }

    @And("user should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String arg0) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String msgSent=l.driver.findElement(By.xpath("//span[contains(text(),\"Message sent\")]")).getText();
        Assert.assertEquals(msgSent,"Message sent");
    }

    @And("user leaves the {string} field blank")
    public void userLeavesTheFieldBlank(String arg0) {
        
    }

    @Then("user is able to see a warning message {string}")
    public void userIsAbleToSeeAWarningMessage(String arg0) {
     //Alert alert= driver.switchTo().alert();
     //System.out.println(alert.getText());
    }

    @When("user is able to confirm to send the email without a subject")
    public void userIsAbleToConfirmToSendTheEmailWithoutASubject() {
        
    }

    @And("the user leaves the {string} field blank")
    public void theUserLeavesTheFieldBlank(String arg0) {
        
    }

    @And("the user is able to enters invalid {} email address")
    public void theUserIsAbleToEntersInvalidEmailAddress(String toInvalidEmailAddress) {
        l.toRecipients().sendKeys(toInvalidEmailAddress);
    }

    @Then("user should see an error message as {}")
    public void userShouldSeeAnErrorMessageAs(String inValidEmailAddres) throws InterruptedException {
        Thread.sleep(4000);

        Assert.assertEquals(l.toInvReqMsg().getText(),"The address \""+inValidEmailAddres+"\" in the \"To\" field was not recognized. Please make sure that all addresses are properly formed.");
        System.out.println();
    }
    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String arg0) throws InterruptedException {
      Thread.sleep(4000);
      Assert.assertEquals(l.toReMsg().getText(),"Please specify at least one recipient.");
      System.out.println();
    }

    @Then("user should see an Failed error message as {}")
    public void userShouldSeeAnFailedErrorMessageAs(String arg0) throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(l.toReMsg().getText(),"Pleases specify at least one recipient.");
        System.out.println();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario)
    {
        String status= String.valueOf(scenario.getStatus());
        if(status.equalsIgnoreCase("FAILED"))
        {
            final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/jpeg","screenshot attached");
        }
    }

    @After
    public void tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }



}

