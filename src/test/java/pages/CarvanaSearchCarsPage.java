package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.PublicKey;
import java.util.List;

public class CarvanaSearchCarsPage extends CarvanaBasePage{

    public  CarvanaSearchCarsPage(){
        super();
    }

    @FindBy(css = "div[data-qa='menu-flex']>button")
    public List<WebElement> filtersOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchBar;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "div[data-qa='result-tile']")
    public  List<WebElement> tile;

    @FindBy(css = "div[class='tk-shell'] picture")
    public List<WebElement> tilePicture;

    @FindBy(css = "div[class='tk-shell'] svg")
    public List<WebElement> addToFavoriteButton;

    @FindBy(css = "div[class*='tk-frame middle-frame']")
    public List<WebElement> tileBody;

    @FindBy(css = "div[data-qa='inventory-type-experiment']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "div[data-qa='trim-mileage']")
    public List<WebElement> trimMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> price;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPayment;

    @FindBy(css = "div[class='down-payment']")
    public List<WebElement> downPaymentInformation;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> deliveryChip;

    @FindBy(css = "button[class*='Button-sc-1a1035-1 ifuuwK c']")
    public WebElement nextButton;

}
