package core;


import logger.LoggerManager;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public class Wait {

    public static void waitUntil(boolean flag,int timeOut){
        int i=0;
        try {
            while (!flag && i<=5000 && i<timeOut){
                Thread.sleep(100);
                i+=100;
            }
        } catch (InterruptedException e) {
            LoggerManager.getInstance().getLogger().warn("Timeout expired");
            e.printStackTrace();
        }
    }
}
