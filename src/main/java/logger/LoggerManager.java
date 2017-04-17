package logger;


import core.ThreadSafeContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Andrei_Muliarchyk on 3/24/2017.
 */
public class LoggerManager {
    private static LoggerManager instance;

    public static LoggerManager getInstance(){
        if(instance == null){
            instance = new LoggerManager();
        }
        return instance;
    }

    private ThreadSafeContainer<Logger> loggerContainer = new ThreadSafeContainer<>();

    public Logger getLogger(){
        if(!loggerContainer.containsCurrentThread()){
            
            loggerContainer.set(LogManager.getLogger("Logger. Thread - " + Thread.currentThread().getId()));
        }
        return loggerContainer.getInstance();
    }

    private final static String PREFIX_OPERATION = "OPERATION";
}
