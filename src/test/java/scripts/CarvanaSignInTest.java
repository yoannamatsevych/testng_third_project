package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaSignInModalPage;

public class CarvanaSignInTest extends CarvanaBase {


    @BeforeMethod
    public void setPage() {
        carvanaSignInModalPage = new CarvanaSignInModalPage();
    }

    /*
    Given user is on "https://www.carvana.com/"
    When user clicks on “SIGN IN” button
    Then user should be navigated to “Sign in” modal
    When user enters email as johndoe   @gmail.com
    And user clicks on "CONTINUE" button
    And user enters password as "abcd1234"
    And user clicks on "SIGN IN" button
    Then user should see error message as "Email address and/or password combination is incorrect.
     */

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validatingSignInErrorMessage() {
        for (int i = 0; i <= 2; i++) {
            try {
                carvanaBasePage.signInButton.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            carvanaSignInModalPage.emailInput.sendKeys("johndoe@gmail.com");
            carvanaSignInModalPage.continueButton.click();
            carvanaSignInModalPage.passwordInput.sendKeys("abcd1234");
            carvanaSignInModalPage.signInButton.click();
            Assert.assertTrue(carvanaSignInModalPage.errorMassage.isDisplayed());
            Assert.assertEquals(carvanaSignInModalPage.errorMassage.getText(),
                    "Email address and/or password combination is incorrect.");
        }


    }
}
