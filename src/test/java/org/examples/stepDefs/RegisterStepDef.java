package org.examples.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.pages.P01_register;
import org.examples.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class RegisterStepDef {
    P03_homePage homePage = new P03_homePage();
    P01_register register = new P01_register();


    @Given("user go to register page")
    public void setRegister()
    {
        homePage.register(Hooks.driver).click();
    }

    @And("user select gender type")
    public void gender()
    {
        register.GenderMale(Hooks.driver).click();
    }


    @And("user enter first name \"automation\" and last name \"tester\"")
    public void name()
    {
        register.FirstName(Hooks.driver).sendKeys("automation");
        register.LastName(Hooks.driver).sendKeys("tester");
    }

    @And("user enter date of birth")
    public void Date_Of_Birth()
    {
        Select Day = new Select(register.DateOfBirthDay(Hooks.driver));
        Day.selectByValue("15");

        Select Month = new Select(register.DateOfBirthMonth(Hooks.driver));
        Month.selectByValue("9");

        Select Year = new Select(register.DateOfBirthYear(Hooks.driver));
        Year.selectByValue("1999");
    }

    @And("user enter email \"test@example.com\" field")
    public void Email()
    {
        register.Email(Hooks.driver).sendKeys("test@example.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void Password()
    {
        register.Password(Hooks.driver).sendKeys("P@ssw0rd");
        register.ConfirmPassword(Hooks.driver).sendKeys("P@ssw0rd");
    }
    @When("user clicks on register button")
    public void Register_BTN()
    {
        register.Register_BTN(Hooks.driver).click();
    }

    @Then("success message should be displayed")
    public void Message() throws InterruptedException {
        SoftAssert soft_assert = new SoftAssert();

        soft_assert.assertEquals(register.Confirmation_Message(Hooks.driver).getText().contains("Your registration completed")
                ,true,"moshkela");

        soft_assert.assertEquals("rgba(76, 177, 124, 1)",register.Confirmation_Message(Hooks.driver).getCssValue("color"));
        System.out.println(register.Confirmation_Message(Hooks.driver).getCssValue("color"));

        soft_assert.assertAll();
    }


}
