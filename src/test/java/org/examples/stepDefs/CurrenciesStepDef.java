package org.examples.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CurrenciesStepDef {
    P03_homePage homePage = new P03_homePage();
    String product;

    @When("user select Euro currency from the dropdown list")
    public void set_Euro(){
        Select Euro = new Select(homePage.currency_Euro(Hooks.driver));
        Euro.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }

    @Then("Euro Symbol (€) is shown on the 4 products displayed in Home page")
    public void verify_Euro()
    {
        for (int i = 0; i < homePage.actual_Price(Hooks.driver).size(); i++)
        {
            product = homePage.actual_Price(Hooks.driver).get(i).getText();
            Assert.assertTrue(product.contains("€"),"Cannot find (€) symbol");
        }
    }


}
