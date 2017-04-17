package weblayer.pages.authorizationby;

import org.openqa.selenium.support.FindBy;
import weblayer.elements.CButton;
import weblayer.elements.Input;
import weblayer.pages.core.BasePage;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public class AuthorizationByGoogle extends BasePage {
    @FindBy(id = "Email")
    private Input googleEmail;
    @FindBy(id = "next")
    private CButton googleNext;
    @FindBy(id = "Passwd")
    private Input googlePassword;
    @FindBy(id = "signIn")
    private CButton googleSubmit;

    public Input getGoogleEmail() {
        return googleEmail;
    }

    public CButton getGoogleNext() {
        return googleNext;
    }

    public Input getGooglePassword() {
        return googlePassword;
    }

    public CButton getGoogleSubmit() {
        return googleSubmit;
    }
}
