package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarvanaHomepageTest extends CarvanaBase{

    /*
    Given user is on "https://www.carvana.com/"
    Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
    And validate url equals  "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validatingPageTitleUrl(){
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

}
