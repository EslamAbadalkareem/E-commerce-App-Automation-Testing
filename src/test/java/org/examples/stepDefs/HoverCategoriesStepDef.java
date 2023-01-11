package org.examples.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class HoverCategoriesStepDef {
    P03_homePage homePage = new P03_homePage();
    List<WebElement> mainCategories = homePage.main_Categories(Hooks.driver);
    Random random = new Random();
    int selectedMainCat = random.nextInt(7);
    boolean isSub;
    String maincatTitle;
    String subcatTitle;

    @When("select one of the main categories to hover randomly")
    public void hover_on_main_category(){
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(mainCategories.get(selectedMainCat)).perform();

//        System.out.print("Main Category number is: " + (selectedMainCat+1));
//        System.out.println("   Main Category is: " + mainCategories.get(selectedMainCat).getText());
        maincatTitle = mainCategories.get(selectedMainCat).getText();
    }



    @And("select one of the  subcategories to hover randomly")
    public void hover_on_sub_category() {

        List<WebElement> subCategories = homePage.sub_Categories(Hooks.driver, (selectedMainCat+1));

        if(!subCategories.isEmpty()) {
            isSub = true;
            Random random1 = new Random();
            int selectedSubCat = random1.nextInt(3);

//            System.out.print("sub Category number is: " + (selectedSubCat+1));
//            System.out.println("  sub Category is: " + subCategories.get(selectedSubCat).getText());
            subcatTitle = subCategories.get(selectedSubCat).getText();
            subCategories.get(selectedSubCat).click();
        }
        else
        {
            isSub = false;
            mainCategories.get(selectedMainCat).click();
        }
    }



    @Then("the page title should be the same")
    public void check_Page()
    {
        String pageTitle = homePage.page_Title(Hooks.driver).getText();

        if (!isSub)
        {
            System.out.println("It is Main Category: ");
            System.out.println("page title is: " + pageTitle);
            System.out.println("mainCategory is: " + maincatTitle);
            Assert.assertEquals(pageTitle , maincatTitle);
        }
        else
        {
            System.out.println("It is Sub Category of: "+ maincatTitle);
            System.out.println("page title is: " + pageTitle);
            System.out.println("subCategory is: " + subcatTitle);
            Assert.assertEquals(pageTitle, subcatTitle);
        }
    }
}
