package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.*;

public class SearchMovie

{
    CsvFileHandler csvFileHandler=new CsvFileHandler();
    TestData testData = new TestData();
    PageHandler pageHandler = new PageHandler();

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
           WebDriver driver = new FirefoxDriver();
           driver.get("https://www.google.co.in");
       }
       else if(browser.contains("chrome"))
       {
           WebDriver driver = new ChromeDriver();
           driver.navigate().to("https://www.google.co.in");
           driver.quit();
       }
       else if(browser.contains("safari"))
       {
           WebDriver driver = new SafariDriver();
       }
    }

    public void runTest()
    {
        pageHandler.getDriver().navigate().to("https://www.google.co.in");
        pageHandler.getDriver().quit();
    }
}
