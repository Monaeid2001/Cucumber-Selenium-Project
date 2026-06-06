package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    private final By newTodoItem = By.cssSelector("[data-testid=\"new-todo\"]");
    private final By newTodoSubmitButton =By.cssSelector("[data-testid=\"submit-newTask\"]");
    public void addNewTodo(String todo){
        driver.findElement(newTodoItem).sendKeys(todo);
        driver.findElement(newTodoSubmitButton).click();
    }

}
