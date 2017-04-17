package weblayer.pages;

import org.openqa.selenium.support.FindBy;
import weblayer.elements.CButton;
import weblayer.elements.Input;
import weblayer.pages.core.BasePage;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private Input loginField;
    @FindBy(id = "password")
    private Input passwordField;
    @FindBy(xpath = "//div[@class = 'b-group']//button[contains(@type,'submit')]")
    private CButton submitButton;
    @FindBy(xpath = "//div[contains(@class,'sign__in')]//i[contains(@class,'google')]")
    private CButton loginWithGoogleAccount;

    public CButton getLoginWithGoogleAccount() {
        return loginWithGoogleAccount;
    }

    public Input getLoginField() {
         return loginField;
    }

    public Input getPasswordField() {
        return passwordField;
    }

    public CButton getSubmitButton() {
         return submitButton;
    }
}
