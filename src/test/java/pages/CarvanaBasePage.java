package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaBasePage {

    public CarvanaBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement logo;

    @FindBy(css = "div[data-qa='menu-wrapper']")
    public List<WebElement> navigationItems;

    @FindBy(css = "div[data-qa='sign-in-wrapper']")
    public WebElement signInButton;

    @FindBy(css = "div[data-qa='header-items']>a")
    public List<WebElement> headerItems;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarManu;



}
