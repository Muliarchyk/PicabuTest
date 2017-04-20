import com.google.inject.Guice;
import com.google.inject.Injector;
import core.ConfigurationManager;
import core.DriverCreator;
import core.DriverManager;
import core.VerifyManager;
import enums.BrowserName;
import logger.LoggerManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.*;
import services.*;
import services.modules.PicabuServiceModule;
import testdata.CSVReader;

import java.io.File;
import java.io.IOException;


/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class BaseTest {
    private Injector injector = Guice.createInjector(new PicabuServiceModule());

    protected final String dataForRefistrationFile = "Data_Registration.csv";
    protected final String dataForAuthorizationFile = "Data_Authorization.csv";

    protected CSVReader reader = new CSVReader();
    protected LoginService loginService = injector.getInstance(LoginService.class);
    protected MainPageService mainPageService = injector.getInstance(MainPageService.class);
    protected ProfilePageService profilePageService = injector.getInstance(ProfilePageService.class);
    protected BestPostsPageService bestPostPageService = injector.getInstance(BestPostsPageService.class);
    protected SearchResultPageService searchResultPageService = injector.getInstance(SearchResultPageService.class);
    protected HotPostsPageService hotPostsPageService = injector.getInstance(HotPostsPageService.class);
    protected RecentPostPageService recentPostPageService = injector.getInstance(RecentPostPageService.class);
    protected AuthorizationByGoogleService authorizationByGoogleService = injector.getInstance(AuthorizationByGoogleService.class);

    @BeforeTest
    public void beforeTest(){
        DriverCreator.getInstance().setBrowser(BrowserName.valueOf(ConfigurationManager.getInstance().getBROWSER()));
    }

    @BeforeMethod
    public void beforeMethod(){
        DriverManager.getInstance().getDriver().get("http://pikabu.ru/");
        LoggerManager.getInstance().getLogger().debug("###############################");
        VerifyManager.getInstance().clean();
    }

    @AfterMethod
    public void afterMethod(){
        LoggerManager.getInstance().getLogger().debug("Clearing cache!");
        DriverManager.getInstance().getDriver().manage().deleteAllCookies();
    }

    @AfterTest
    public void afterTest(){

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        DriverManager.getInstance().closeDriver();
    }
}
