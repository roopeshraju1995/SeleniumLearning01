package ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHandler {

    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }


    public JavascriptExecutor getJsExecuter() {
        return (JavascriptExecutor)  getDriver();
    }


    public void jsClickBtn(WebElement button) {
        getJsExecuter().executeScript("arguments[0].click();", button);
    }
}
