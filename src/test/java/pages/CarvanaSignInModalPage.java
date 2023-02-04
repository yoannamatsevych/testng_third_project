package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.CarvanaBase;
import utilities.Driver;

public class CarvanaSignInModalPage extends CarvanaBasePage {

    public CarvanaSignInModalPage(){
        super();
    }

    @FindBy(css = "input[data-qa='sign-in-email']")
    public WebElement emailInput;

    @FindBy(css = "button[data-qa='enter-email-submit']")
    public WebElement continueButton;

    @FindBy(css = "input[data-qa='sign-in-password']")
    public WebElement passwordInput;

    @FindBy(css = "button[data-qa='sign-in-submit']")
    public WebElement signInButton;

    @FindBy(css = "div[class*='error-banner__c']")
    public WebElement errorMassage;

}
