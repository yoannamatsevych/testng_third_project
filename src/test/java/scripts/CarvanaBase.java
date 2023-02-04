package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaBasePage;
import pages.CarvanaSearchCarsPage;
import pages.CarvanaSignInModalPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CarvanaBase {


    WebDriver driver;
    CarvanaBasePage carvanaBasePage;
    CarvanaSignInModalPage carvanaSignInModalPage;
    CarvanaSearchCarsPage carvanaSearchCarsPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));

            carvanaBasePage = new CarvanaBasePage();

        }
    


    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }


}
