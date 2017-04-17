package weblayer.pages;

import org.openqa.selenium.support.FindBy;
import weblayer.elements.CButton;
import weblayer.elements.Label;
import weblayer.pages.core.BasePage;

/**
 * Created by Andrei_Muliarchyk on 3/24/2017.
 */
public class ProfilePage extends BasePage{

    private final String profileDivXpath = "//div[@class='b-user-menu']";
    private final String listUlXpath = profileDivXpath + "//ul[contains(@class,'list')]";


    //Header
    @FindBy(xpath = profileDivXpath+"//div[@class='b-user-menu__header']//a[contains(@href,'profile')]")
    private CButton userName;
    @FindBy(xpath = profileDivXpath+"//div[@class='b-user-menu__header']//a[contains(@class,'notification')]")
    private CButton userNotification;
    @FindBy(xpath = profileDivXpath+"//div[@class='b-user-menu__header']//div[contains(@class,'logout')]")
    private CButton logout;
    //Menu list
    @FindBy(xpath = listUlXpath+"//span[contains(@class,'rating')]/parent::li")
    private Label userRating;
    @FindBy(xpath = listUlXpath+"//span[contains(@class,'subscribers')]/parent::li")
    private Label userSubscriber;
    @FindBy(xpath = listUlXpath+"//a[contains(@href,'edit')]")
    private CButton editUserProfile;
    @FindBy (xpath = listUlXpath+"//a[contains(@href,'subs') and not(@class)]")
    private CButton userList;
    @FindBy(xpath = listUlXpath+"//a[contains(@href,'subs') and contains(@class,'list__count')]")
    private CButton userListCount;
    @FindBy(xpath = listUlXpath+"//span[contains(@class,'my-stories')]/parent::li//a")
    private CButton userPosts;
    @FindBy(xpath = listUlXpath+"//a[contains(@href,'freshitems')]")
    private CButton userMessages;
    @FindBy(xpath = listUlXpath+"//a[contains(@href,'commented')]")
    private CButton userComments;
    @FindBy(xpath = listUlXpath+"//a[contains(@href,'interested')]")
    private CButton userMarks;
    @FindBy(xpath = listUlXpath+"//a[contains(@href,'saved')]")
    private CButton userSavedPosts;

    public CButton getUserName() {
        return userName;
    }

    public CButton getUserNotification() {
        return userNotification;
    }

    public CButton getLogout() {
        return logout;
    }

    public Label getUserRating() {
        return userRating;
    }

    public Label getUserSubscriber() {
        return userSubscriber;
    }

    public CButton getEditUserProfile() {
        return editUserProfile;
    }

    public CButton getUserList() {
        return userList;
    }

    public CButton getUserListCount() {
        return userListCount;
    }

    public CButton getUserPosts() {
        return userPosts;
    }

    public CButton getUserMessages() {
        return userMessages;
    }

    public CButton getUserComments() {
        return userComments;
    }

    public CButton getUserMarks() {
        return userMarks;
    }

    public CButton getUserSavedPosts() {
        return userSavedPosts;
    }

}
