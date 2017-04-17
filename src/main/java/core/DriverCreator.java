package core;

import enums.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Andrei_Muliarchyk on 4/7/2017.
 */
public class DriverCreator {
    private static DriverCreator instance;
    public static DriverCreator getInstance(){
        if(instance == null){
            instance = new DriverCreator();
        }
        return instance;
    }

    private BrowserName defaultBrowserName = BrowserName.Firefox;

    public WebDriver createDriver(){
        switch (defaultBrowserName) {
            case Chrome:
                return new ChromeDriver();
            case Firefox:
                return new FirefoxDriver();
        }
        return null;
    }

    public void setBrowser (BrowserName browser) {
        defaultBrowserName = browser;
    }
}
