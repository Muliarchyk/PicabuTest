package weblayer.pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import weblayer.elements.CButton;
import weblayer.elements.Input;
import weblayer.pages.core.BasePage;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class RegisterPage extends BasePage {

    @FindBy(xpath = "//input[@id='signup-u']")
    private Input loginField;
    @FindBy(xpath = "//input[@type = 'email']")
    private Input emailField;
    @FindBy(xpath = "//input[@id='signup-p']")
    private Input passwordField;
    @FindBy(xpath = "//form[@id='form2']//button[@type = 'submit']")
    private CButton submitButton;

    public Input getLoginField() {
        return loginField;
    }

    public Input getEmailField() {
        return emailField;
    }

    public Input getPasswordField() {
        return passwordField;
    }

    public CButton getSubmitButton() {
        return submitButton;
    }
}
