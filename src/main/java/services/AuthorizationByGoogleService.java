package services;

import com.google.inject.Provider;
import logger.LoggerManager;
import services.interfaces.IAuthorizationByGoogleService;
import weblayer.pages.authorizationby.AuthorizationByGoogle;

import javax.inject.Inject;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public class AuthorizationByGoogleService implements IAuthorizationByGoogleService {
    @Inject
    private Provider<AuthorizationByGoogle> authorizationByGoogleProvider;

    protected AuthorizationByGoogle getPage(){
        return authorizationByGoogleProvider.get();
    }
    @Override
    public void inputEmail(String email) {
        getPage().getGoogleEmail().sendKeys(email);
        LoggerManager.getInstance().getLogger().info("The value '"+email+"'is entered in the email field");
    }

    @Override
    public void inputPassword(String password) {
        getPage().getGooglePassword().sendKeys(password);
        LoggerManager.getInstance().getLogger().info("The value '"+password+"'is entered in the password field");
    }

    @Override
    public void clickNext() {
        getPage().getGoogleNext().click();
        LoggerManager.getInstance().getLogger().info("Next button clicked.");
    }

    @Override
    public void clickSubmit() {
        getPage().getGoogleSubmit().click();
        LoggerManager.getInstance().getLogger().info("Submit button clicked.");
    }
}
