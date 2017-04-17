package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Andrei_Muliarchyk on 4/7/2017.
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;

    public static ConfigurationManager getInstance(){
        if(instance == null){
            instance = new ConfigurationManager();
            instance.provide();
        }
        return instance;
    }

    private String BROWSER;
    private String AUTHORIZATION_LOGIN;
    private String AUTHORIZATION_PASSWORD;
    private String GOOGLE_AUTHORIZATION_EMAIL;
    private String GOOGLE_AUTHORIZATION_PASSWORD;
    private String PATH_SCREENSHOTS;

    private Properties prop = new Properties();
    InputStream input = null;

    private void provide() {
        try {
            input = new FileInputStream("src/test/resources/Configuration.properties");

            prop.load(input);
            BROWSER = prop.getProperty("BROWSER");
            AUTHORIZATION_LOGIN = prop.getProperty("AUTHORIZATION_LOGIN");
            AUTHORIZATION_PASSWORD = prop.getProperty("AUTHORIZATION_PASSWORD");
            GOOGLE_AUTHORIZATION_EMAIL = prop.getProperty("GOOGLE_AUTHORIZATION_EMAIL");
            GOOGLE_AUTHORIZATION_PASSWORD = prop.getProperty("GOOGLE_AUTHORIZATION_PASSWORD");
            PATH_SCREENSHOTS = prop.getProperty("PATH_SCREENSHOTS");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getBROWSER() {
        return BROWSER;
    }

    public String getAUTHORIZATION_LOGIN() {
        return AUTHORIZATION_LOGIN;
    }

    public String getAUTHORIZATION_PASSWORD() {
        return AUTHORIZATION_PASSWORD;
    }

    public String getGOOGLE_AUTHORIZATION_EMAIL() {
        return GOOGLE_AUTHORIZATION_EMAIL;
    }

    public String getGOOGLE_AUTHORIZATION_PASSWORD() {
        return GOOGLE_AUTHORIZATION_PASSWORD;
    }

    public String getPATH_SCREENSHOTS() {
        return PATH_SCREENSHOTS;
    }
}
