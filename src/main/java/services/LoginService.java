package services;
import com.google.inject.Inject;
import com.google.inject.Provider;
import logger.LoggerManager;
import services.interfaces.ILoginService;
import weblayer.elements.CButton;
import weblayer.elements.Input;
import weblayer.pages.LoginPage;


/**
 * Created by Andrei_Muliarchyk on 3/24/2017.
 */
public class LoginService implements ILoginService {
    @Inject
    private Provider<LoginPage> loginPageProvider;

    protected LoginPage getPage() {
        return loginPageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        Input loginInput = getPage().getLoginField();
        Input passwordInput = getPage().getPasswordField();
        CButton submitBtn = getPage().getSubmitButton();

        if (loginInput.isDisplayed()
                & passwordInput.isDisplayed()
                & submitBtn.isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Login page is open.");
            return true;
        }else {
            LoggerManager.getInstance().getLogger().info("Login page does not contain all items!");
            return false;
        }
    }

    @Override
    public void inputLogin(String login) {
        getPage().getLoginField().sendKeys(login);
        LoggerManager.getInstance().getLogger().info("The value '"+login+"'is entered in the login field");
    }

    @Override
    public void inputPassword(String password) {
        getPage().getPasswordField().sendKeys(password);
        LoggerManager.getInstance().getLogger().info("The value '"+password+"'is entered in the password field");
    }

    @Override
    public void clickSubmit() {
        getPage().getSubmitButton().click();
        LoggerManager.getInstance().getLogger().info("Submit button clicked.");
    }

    @Override
    public void clickGoogleAccountButton() {
        getPage().getLoginWithGoogleAccount().click();
        LoggerManager.getInstance().getLogger().info("Login with google account button clicked.");
    }
}
