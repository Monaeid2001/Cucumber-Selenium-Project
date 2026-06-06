package com.qacart.todo.steps;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.EnvUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class TodoSteps {
    WebDriver driver;
@Given("User is at the todo page")
    public void UserIsAtTheTodoPage() throws IOException {
    driver =  DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load(EnvUtil.getInstance().getBaseUrl());
    loginPage.login(EnvUtil.getInstance().getUserEmail(), EnvUtil.getInstance().getUserPassword());
    }
@When("User add a new todo")
    public void UserAddAnewTodo(){
    new TodoPage(driver).clickOnAddTodoButton();
   new NewTodoPage(driver).addNewTodo("Learn Cucumber");

    }
@Then("Todo should be added successfully")
    public void TodoShouldBeAddedSuccessfully(){
    String todoItem= new TodoPage(driver).getLastTodoItemText();
    Assert.assertEquals(todoItem,"Learn Cucumber");
    driver.quit();

    }

}
