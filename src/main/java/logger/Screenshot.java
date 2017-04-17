package logger;

import core.ConfigurationManager;
import core.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

/**
 * Created by Andrei_Muliarchyk on 4/17/2017.
 */
public class Screenshot extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            WebDriver augmentedDriver = new Augmenter().augment(DriverManager.getInstance().getDriver());
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            String path = ConfigurationManager.getInstance().getPATH_SCREENSHOTS() + source.getName();
            FileUtils.copyFile(source, new File(path));
            Reporter.setCurrentTestResult(result);
            Reporter.log(ConfigurationManager.getInstance().getPATH_SCREENSHOTS());
            //Reporter.log("screenshot saved at "+ConfigurationManager.getInstance().getPATH_SCREENSHOTS()+"\\reports\\"+result.getName()+".jpg");
            Reporter.log("<br><img src='screenshots/"+source.getName()+"' hight='800' width='800'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.setCurrentTestResult(null);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("<p><font size=\"5\" color=\"red\" face=\"Arial\">Passed</font>");
    }
}
