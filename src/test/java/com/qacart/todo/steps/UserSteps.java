package com.qacart.todo.steps;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.EnvUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class UserSteps {
     WebDriver driver;

    @Given("User is at the login page")
    public void UserIsAtTheLoginPage() throws IOException {
        driver = DriverFactory.getDriver();
       new LoginPage(driver).load(EnvUtil.getInstance().getBaseUrl());

    }
    @When("User fills email and password and login")
    public void UserFillsEmailAndPasswordAndLogin() throws IOException {
     new LoginPage(driver).login(EnvUtil.getInstance().getUserEmail(), EnvUtil.getInstance().getUserPassword());

    }
    @Then("Welcome message should be displayed")
    public void WelcomeMessageShouldBeDisplayed(){
      boolean isWelcomeMessageDisplayed = new TodoPage(driver).isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeMessageDisplayed);
        driver.quit();
    }
}
