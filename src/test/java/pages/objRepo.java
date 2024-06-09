package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class objRepo {

public  WebDriver driver;
    public objRepo(WebDriver driver)
    {
      this.driver=driver;

    }

   // WebElement username=driver.findElement(By.id("user-name"));
    //WebElement password=driver.findElement(By.id("password"))
   public final  String username ="//input[@type=\"email\"]";
    public  final  String Next ="//span[contains(text(),\"Next\")]";
    public  final  String password= "//input[@type=\"password\"]";
    public  final String notNow ="//span[contains(text(),\"Not now\")]";
    public  final  String compose =" //div[contains(text(),\"Compose\")]/parent::div";
    public  final  String toRecipients="//input[@aria-label=\"To recipients\"]";
    public  final  String subjectbox="//input[@name=\"subjectbox\"]";
    public  final  String Body="//div[@aria-label=\"Message Body\"]";
    public  final  String Send="//td//div//div[contains(text(),\"Send\")]";
    public  final  String toReqMsg="//div[contains(text(),\"Please specify at least one recipient.\")]";
    public  final  String toInvReqMsg="//div[@id=\"c1\"]";



    public WebElement UserName()
    {
        return driver.findElement(By.xpath(username));

    }
    public WebElement toInvReqMsg()
    {
        return driver.findElement(By.xpath(toInvReqMsg));

    }
    public WebElement next()
    {
        return driver.findElement(By.xpath(Next));

    }
    public WebElement password()
    {
        return driver.findElement(By.xpath(password));

    }

    public WebElement notNow()
    {
        return driver.findElement(By.xpath(notNow));

    }
    public WebElement compose()
    {
        return driver.findElement(By.xpath(compose));

    }
    public WebElement toRecipients()
    {
        return driver.findElement(By.xpath(toRecipients));

    }
    public WebElement subjectbox()
    {
        return driver.findElement(By.xpath(subjectbox));

    }
    public WebElement Send()
    {
        return driver.findElement(By.xpath(Send));

    }
    public WebElement toReMsg()
    {
        return driver.findElement(By.xpath(toReqMsg));

    }
    public WebElement Body()
    {
        return driver.findElement(By.xpath(Body));

    }



}
