package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FaceBookPage {
  public FaceBookPage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }
  @FindBy(xpath = "//button[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")
  public WebElement  cookiesKabul;


  @FindBy(xpath = "//*[@id='email']")
    public WebElement emailKutusu;

  @FindBy(xpath ="//*[@id='pass']")
    public WebElement pass;
  @FindBy(xpath = "//*[@name='login']")
    public WebElement login;
  @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement sifreyanlis;
}
