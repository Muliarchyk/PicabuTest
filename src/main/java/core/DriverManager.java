package core;

import org.openqa.selenium.WebDriver;



/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public class DriverManager {
    private static DriverManager instance;

    public synchronized static DriverManager getInstance(){
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }


    private ThreadSafeContainer<WebDriver> driverContainer = new ThreadSafeContainer<>();

    public WebDriver getDriver(){
       if (!driverContainer.containsCurrentThread()){
           driverContainer.set(DriverCreator.getInstance().createDriver());
       }
       return driverContainer.getInstance();
    }

    public void closeDriver(){
        driverContainer.getInstance().quit();
    }

}
