package ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class PageHandler {

    public WebDriver driver ;


    public JavascriptExecutor getJsExecuter() {
        return (JavascriptExecutor)  driver;
    }


    public void jsClickBtn(WebElement button) {
        getJsExecuter().executeScript("arguments[0].click();", button);
    }

    public FirefoxDriver  getFireFox()
    {
      return (FirefoxDriver) (driver=new FirefoxDriver());
    }

    public ChromeDriver getChrome()
    {
        return (ChromeDriver) (driver=new ChromeDriver());
    }

    public SafariDriver getSafari()
    {
        return (SafariDriver) (driver=new SafariDriver());
    }
}
