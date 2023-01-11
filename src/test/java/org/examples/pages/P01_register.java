package org.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_register {

    //    create WebElement method to register button

    public WebElement GenderMale(WebDriver driver)
    {
        WebElement GenderMale= driver.findElement(By.id("gender-male"));
        return (GenderMale);
    }
    public WebElement GenderFemale(WebDriver driver)
    {
        WebElement GenderFemale= driver.findElement(By.id("gender-female"));
        return (GenderFemale);
    }

    public WebElement FirstName(WebDriver driver)
    {
        WebElement Firstname = driver.findElement(By.id("FirstName"));
        return Firstname;
    }

    public WebElement LastName(WebDriver driver)
    {
        WebElement Lastname = driver.findElement(By.id("LastName"));
        return Lastname;
    }

    public WebElement DateOfBirthDay(WebDriver driver)
    {
        WebElement DateOfBirthDay = driver.findElement(By.name("DateOfBirthDay"));
        return DateOfBirthDay;
    }
    public WebElement DateOfBirthMonth(WebDriver driver)
    {
        WebElement DateOfBirthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        return DateOfBirthMonth;
    }
    public WebElement DateOfBirthYear(WebDriver driver)
    {
        WebElement DateOfBirthYear = driver.findElement(By.name("DateOfBirthYear"));
        return DateOfBirthYear;
    }

    public WebElement Email(WebDriver driver)
    {
        WebElement Email = driver.findElement(By.id("Email"));
        return Email;
    }

    public WebElement Password(WebDriver driver)
    {
        WebElement Password = driver.findElement(By.id("Password"));
        return (Password);
    }
    public WebElement ConfirmPassword(WebDriver driver)
    {
        WebElement ConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        return (ConfirmPassword);
    }
    public WebElement Register_BTN(WebDriver driver)
    {
        WebElement BTN = driver.findElement(By.id("register-button"));
        return (BTN);
    }

    public WebElement Confirmation_Message(WebDriver driver)
    {
        WebElement msg = driver.findElement(By.className("result"));
        return (msg);
    }

    public String Confirmation_color(WebDriver driver)
    {
        String msg = driver.findElement(By.className("register-continue-button")).getAttribute("completed");
        return (msg);
    }

    public WebElement Continue(WebDriver driver)
    {
        WebElement Continue = driver.findElement(By.linkText("Continue"));
        return (Continue);
    }

    public WebElement Exist(WebDriver driver)
    {
        WebElement Exist = driver.findElement(By.linkText("Exist"));
        return (Exist);
    }



}
