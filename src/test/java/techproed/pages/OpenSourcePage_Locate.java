package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage_Locate {
    /*
    Locatelerimizi tek bir yerede duzenli bir sekilde tutabilmek icin;
    1-ilk olarak olusturmus oldugumuz Page classimizda bir constructor olustururuz.
    2-PageFactory classindan initelements() methodu ile driveri tanitiriz.
    3-FindBy notasyonu kullanarak locatelerimizi aliriz.
     */
    public OpenSourcePage_Locate(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//*[@name='username']")
    public WebElement username;

    @FindBy(xpath="//*[@name='password']")
    public WebElement password;
    @FindBy(xpath="//*[@type='submit']")
    public WebElement login;

    @FindBy(xpath="//h6")
    public WebElement dashboard;


}
