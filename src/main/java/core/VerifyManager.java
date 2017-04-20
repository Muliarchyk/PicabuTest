package core;

import logger.LoggerManager;
import org.testng.asserts.SoftAssert;


/**
 * Created by Andrei_Muliarchyk on 3/30/2017.
 */
public class VerifyManager {
    private static VerifyManager instance;
    private ThreadSafeContainer<SoftAssert> softAssertContainer = new ThreadSafeContainer<>();

    public static synchronized VerifyManager getInstance(){
        if (instance == null){
            instance = new VerifyManager();
        }
        return instance;
    }
    public void clean(){
        softAssertContainer.clearContainer();
    }

    public void isTrue(boolean condition) {
        if(!condition){
            getAsserter().fail();
        }
    }

    public SoftAssert getAsserter(){
        if (!softAssertContainer.containsCurrentThread()){
            softAssertContainer.set(new SoftAssert());
        }
        return softAssertContainer.getInstance();
    }
}
