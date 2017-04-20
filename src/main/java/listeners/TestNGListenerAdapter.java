package listeners;

import com.epam.reportportal.apache.http.annotation.ThreadSafe;
import com.epam.reportportal.message.ReportPortalMessage;
import core.ConfigurationManager;
import core.DriverManager;
import logger.LoggerManager;
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
@ThreadSafe
public class TestNGListenerAdapter extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver augmentedDriver = new Augmenter().augment(DriverManager.getInstance().getDriver());
        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
//            String path = ConfigurationManager.getInstance().getPATH_SCREENSHOTS() + source.getName();
//            FileUtils.copyFile(source, new File(path));
//            Reporter.setCurrentTestResult(result);
//            Reporter.log("<br><img src='screenshots/"+source.getName()+"' hight='800' width='800'/> </a>");
        ReportPortalMessage message = new ReportPortalMessage(source,result.toString());
        LoggerManager.getInstance().getLogger().info(message);
        Reporter.setCurrentTestResult(null);
    }
}
