package scripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaBasePage;
import pages.CarvanaSearchCarsPage;
import utilities.DataHandler;
import utilities.Driver;
import utilities.Waiter;

import java.util.stream.IntStream;

public class CarvanaSearchCarsTest extends CarvanaBase {


    @BeforeMethod
    public void setPage(){

        carvanaSearchCarsPage = new CarvanaSearchCarsPage();

        for(int i=0; i<=2;i++){
            try{
                carvanaBasePage.searchCarManu.click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }


    }

        /*
        Given user is on "https://www.carvana.com/"
        When user clicks on "SEARCH CARS" link
        Then user should be routed to "https://www.carvana.com/cars"
        And user should see filter options
        |PAYMENT & PRICE      |
        |MAKE & MODEL      |
        |BODY TYPE |
        |YEAR & MILEAGE      |
        |FEATURES      |
        |MORE FILTERS |
         */


    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validatingFilterOptionOnCarSearchPage(){



        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] expectedFilterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE",
                "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < expectedFilterOptions.length; i++) {
            Assert.assertEquals(carvanaSearchCarsPage.filtersOptions.get(i).getText(), expectedFilterOptions[i]);
        }

    }
    /*
        Given user is on "https://www.carvana.com/"
        When user clicks on "SEARCH CARS" link
        Then user should be routed to "https://www.carvana.com/cars"
        When user enters "mercedes-benz" to the search input box
        And user clicks on "GO" button in the search input box
        Then user should see "mercedes-benz" in the url
        And validate each result tile

        VALIDATION OF EACH TILE INCLUDES BELOW
    Make sure each result tile is displayed with below information
    1. an image
    2. add to favorite button
    3. tile body
    ALSO VALIDATE EACH TILE BODY:
    Make sure each tile body has below information
    1. Inventory type - text should be displayed and should not be null or empty
    2. Year-Make-Model information - text should be displayed and should not be null or empty
    3. Trim-Mileage information - text should be displayed and should not be null or empty
    4. Price - Make sure that each price is more than zero
    5. Monthly Payment information - text should be displayed and should not be null or empty
    6. Down Payment information - text should be displayed and should not be null or empty
    7. Delivery chip must be displayed, and text is not null or empty
    */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validatingSearchResultTiles(){
        carvanaSearchCarsPage.searchBar.sendKeys("mercedes-benz");
        carvanaSearchCarsPage.goButton.click();

        Waiter.waitUntilTitleIs("Used Mercedes-Benz For Sale Online | Carvana", 30);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));


       while(carvanaSearchCarsPage.nextButton.isEnabled()) {
           IntStream.range(0, carvanaSearchCarsPage.tile.size()).forEach(i -> {
               Assert.assertTrue(carvanaSearchCarsPage.tilePicture.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.addToFavoriteButton.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.tileBody.get(i).isDisplayed());

               Assert.assertTrue(carvanaSearchCarsPage.inventoryType.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.inventoryType.get(i) != null
                       && !carvanaSearchCarsPage.inventoryType.get(i).getText().isEmpty());

               Assert.assertTrue(carvanaSearchCarsPage.yearMakeModel.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.yearMakeModel.get(i) != null
                       && !carvanaSearchCarsPage.yearMakeModel.get(i).getText().isEmpty());

               Assert.assertTrue(carvanaSearchCarsPage.trimMileage.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.trimMileage.get(i) != null
                       && !carvanaSearchCarsPage.trimMileage.get(i).getText().isEmpty());

               Assert.assertTrue(DataHandler.convertStringToInt(
                       carvanaSearchCarsPage.price.get(i).getText()) > 0);

               Assert.assertTrue(carvanaSearchCarsPage.monthlyPayment.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.monthlyPayment.get(i) != null
                       && !carvanaSearchCarsPage.monthlyPayment.get(i).getText().isEmpty());

               Assert.assertTrue(carvanaSearchCarsPage.downPaymentInformation.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.downPaymentInformation.get(i) != null
                       && !carvanaSearchCarsPage.downPaymentInformation.get(i).getText().isEmpty());

               Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).isDisplayed());
               Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i) != null
                       && !carvanaSearchCarsPage.deliveryChip.get(i).getText().isEmpty());

               carvanaSearchCarsPage.nextButton.click();

           });

       }
    }

}
