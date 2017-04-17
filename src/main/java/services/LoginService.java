package services;
import com.google.inject.Inject;
import com.google.inject.Provider;
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
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void inputLogin(String login) {
        getPage().getLoginField().sendKeys(login);
    }

    @Override
    public void inputPassword(String password) {
        getPage().getPasswordField().sendKeys(password);
    }

    @Override
    public void clickSubmit() {
        getPage().getSubmitButton().click();
    }

    @Override
    public void loginWithGoogleAccount() {
        getPage().getLoginWithGoogleAccount().click();
    }
}
