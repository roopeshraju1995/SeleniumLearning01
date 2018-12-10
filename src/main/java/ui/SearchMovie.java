package ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SearchMovie
{
    CsvFileHandler csvFileHandler=new CsvFileHandler();
    TestData testData = new TestData();
    public static WebDriver driver ;

    public Map<List<String>, List<String>> movieWithId = new HashMap<List<String>, List<String>>();
    private List<String> id;
    private List<String> name;
    private String movieListFilePath="/Users/coviam/Desktop/SeleniumLearning01/src/main/resources/testdata/movie_name_list.csv";

    public String browser;

    public void readTheTestData()
    {
        try {
            List<TestData> listOfMovies=csvFileHandler.loadCsvFromFile(new File(movieListFilePath),TestData.class);
            for(TestData listOfIdMovies : listOfMovies) {
                testData.setId(listOfIdMovies.getId());
                testData.setMovieName(listOfIdMovies.getMovieName());
                id= Collections.singletonList(listOfIdMovies.getId());
                name= Collections.singletonList(listOfIdMovies.getMovieName());
                movieWithId.put(id,name);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("unable to print the movies list",e);
        }
    }


    public void setBroswer()
    {
        browser="chrome";
    }

    public void setBrowserConfig()
    {
       if (browser.contains("fireFox"))
       {
           driver=new FirefoxDriver();
       }
       else if(browser.contains("chrome"))
       {
           driver=new ChromeDriver();
       }
       else if(browser.contains("safari"))
       {
           driver=new SafariDriver();
       }
    }

    public void runTest()
    {
        driver.navigate().to("https://www.google.co.in");
        driver.quit();
    }

    public void provideImplicitWait()
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void provideExplicitWait(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public JavascriptExecutor getJsExecuter() {
        return (JavascriptExecutor)  driver;
    }


    public void jsClickBtn(WebElement button) {
        getJsExecuter().executeScript("arguments[0].click();", button);
    }



}
