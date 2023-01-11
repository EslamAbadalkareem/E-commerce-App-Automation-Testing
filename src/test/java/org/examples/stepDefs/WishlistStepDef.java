package org.examples.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    int qty = 0;
    boolean isBigger = false;

    @When("user click on wishlist icon")
    public void add_wishlist() {
        homePage.wish_logo(Hooks.driver).click();
    }

    @Then("success message is displayed")
    public void validate_msg() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.success_msg(Hooks.driver).getText(),
                "The product has been added to your wishlist");
        softAssert.assertAll();
    }

    @And("background color is green")
    public void validate_bg() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println(" Actual:" + Color.fromString(homePage.success_bar(Hooks.driver).
                getCssValue("background-color")).asHex());

        softAssert.assertEquals(Color.fromString(homePage.success_bar(Hooks.driver).
                        getCssValue("background-color")).asHex()
                , "#4bb07a");

        softAssert.assertAll();
    }


    @And("user wait until this success message with green color to disappear")
    public void delay() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.invisibilityOf(homePage.success_Bar(Hooks.driver)));
    }

    @When("click on Wishlist Tab")
    public void wishlist()
    {
        homePage.wishlist_btn(Hooks.driver).click();
    }
    @Then("Verify qty value bigger than 0")
    public void qty()
    {
        qty = Integer.parseInt(homePage.Qty(Hooks.driver).getAttribute("value"));
        System.out.println("The quantity is: "+ qty);
        if (qty > 0)
        {
            isBigger = true;
        }
        Assert.assertTrue(isBigger);
    }
}
