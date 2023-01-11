package org.examples.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.pages.P02_login;
import org.examples.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class LoginStepDef {

    P03_homePage homePage = new P03_homePage();
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void setLogin()
    {
        homePage.Login(Hooks.driver).click();
    }
    @And("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void valid_login_Data()
    {
        login.Email(Hooks.driver).sendKeys("test@example.com");
        login.Password(Hooks.driver).sendKeys("P@ssw0rd");
    }
    @And ("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void invalid_login_Data()
    {
        login.Email(Hooks.driver).sendKeys("wrong@example.com");
        login.Password(Hooks.driver).sendKeys("P@ssw0rd");
    }
    @When("user press on login button")
    public void login_BTN()
    {
        login.login_BTN(Hooks.driver).click();
    }

    @Then ("user login to the system successfully")
    public void valid_Message()
    {
        SoftAssert soft_assert = new SoftAssert();
        soft_assert.assertEquals("https://demo.nopcommerce.com/", Hooks.driver.getCurrentUrl());
        soft_assert.assertEquals(login.valid_Assert(Hooks.driver).getText().contains("My account"),
                true, "(My Account) tab doesn't appear");
        soft_assert.assertAll();
    }

    @Then("Step 4 user could not login to the system")
    public void invalid_Message()
    {
        SoftAssert soft_assert = new SoftAssert();
        soft_assert.assertEquals(login.invalid_Assert(Hooks.driver).getText().contains("Login was unsuccessful"),
                true,"(Login was unsuccessful) message doesn't appear");

        soft_assert.assertEquals(Color.fromString(login.invalid_Assert(Hooks.driver).getCssValue("color")).asHex(),
                Color.fromString("rgba(228, 67, 75, 1)").asHex());

        System.out.println(Color.fromString(login.invalid_Assert(Hooks.driver).getCssValue("color")).asHex());

        soft_assert.assertAll();
    }

}
