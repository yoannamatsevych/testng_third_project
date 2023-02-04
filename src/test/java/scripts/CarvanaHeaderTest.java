package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CarvanaHeaderTest extends CarvanaBase{


    /*
    Given user is on "https://www.carvana.com/"
    Then validate the logo of the “Carvana” is displayed
    */
    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validatingCarvanaLogo() {

        for (int i = 0; i <= 2; i++) {
            try {
                Assert.assertTrue(carvanaBasePage.logo.isDisplayed());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }


    /*
    Given user is on "https://www.carvana.com/"
    Then validate the navigation section items below are displayed
     */
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validatingNavigationSection(){

        String[] expectedNavigationItems = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for (int i = 0; i < expectedNavigationItems.length; i++) {
            Assert.assertTrue(carvanaBasePage.navigationItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaBasePage.navigationItems.get(i).getText(), expectedNavigationItems[i]);
        }

    }



}
