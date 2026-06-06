package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    private final By addTodoButton = By.cssSelector("[data-testid=\"add\"]");
    private final By todoItem= By.cssSelector("[data-testid=\"todo-item\"]");
    private final By welcomeMessage = By.cssSelector("[data-testid=\"welcome\"]");

    public boolean isWelcomeMessageDisplayed(){
        return driver.findElement(welcomeMessage).isDisplayed();
    }
    public void clickOnAddTodoButton(){
        driver.findElement(addTodoButton).click();
    }
    public String getLastTodoItemText(){
        return driver.findElements(todoItem).get(0).getText();
    }
}
