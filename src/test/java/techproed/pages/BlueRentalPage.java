package techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="(//*[@role='button'])[1]")
    public WebElement login;
    @FindBy(xpath="//*[@id='formBasicEmail']")
    public WebElement email;
    @FindBy(xpath="//*[@id='dropdown-basic-button']")
    public WebElement verify;
    @FindBy(xpath="//*[@role='alert']")
    public WebElement hataMesaji;

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement login3;
    @FindBy(xpath="//*[text()='Logout']")
    public WebElement logout;
    @FindBy(xpath="//*[@class='ajs-button ajs-ok']")
    public WebElement ok;

    /*Bu bir örnektir
    @FindBy(xpath = "//*[text()='OK']")//-> Linklerin listesinin locati
    public List<WebElement> listler;
    Normalde Webelementleri locate için findelements kullanıyorduk
    TestNG de page class'ında bunun kullanımı yukarıdaki örnekteki gibidir

     */

}
