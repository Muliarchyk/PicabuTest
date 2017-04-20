package weblayer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import weblayer.elements.CButton;
import weblayer.elements.Input;
import weblayer.elements.Tab;
import weblayer.pages.core.BasePage;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class MainPage extends BasePage {

    //Search
    @FindBy(id = "search_menu")
    private Input searchField;
    //SearchButton
    @FindBy(xpath = "//input[@class = 'search_btn']")
    private CButton searchButton;
    //Add post button
    @FindBy (xpath = "//div[@id = 'right_menu']//div[contains(@class,'b-button')]")
    private CButton addPostButton;
    //Hot tab
    @FindBy (xpath = "//a[@href='http://pikabu.ru/hot']")
    private Tab hotPostsTab;
    //Best tab
    @FindBy (xpath = "//a[@href='http://pikabu.ru/best']")
    private Tab bestPostsTab;
    //Recent tab
    @FindBy (xpath = "//a[@href='http://pikabu.ru/new']")
    private Tab recentPostsTab;
    //Communities tab
    @FindBy (xpath = "//a[@href='http://pikabu.ru/communities']")
    private Tab communitiesPostsTab;
    //Login tab
    @FindBy(xpath = "//ul[contains(@class,'center')]//li[1]")
    private Tab loginTab;
    //Registration tab
    @FindBy(xpath = "//ul[contains(@class,'center')]//li[2]")
    private Tab registerTab;
    //Unreg message
    @FindBy(xpath = "//div[@id ='unreg_message']")
    private WebElement UnregMessage;

    public Input getSearchField() {
        return searchField;
    }

    public CButton getSearchButton() {
        return searchButton;
    }

    public CButton getAddPostButton() {
        return addPostButton;
    }

    public Tab getHotPostsTab() {
        return hotPostsTab;
    }

    public Tab getBestPostsTab() {
        return bestPostsTab;
    }

    public Tab getRecentPostsTab() {
        return recentPostsTab;
    }

    public Tab getCommunitiesPostsTab() {
        return communitiesPostsTab;
    }

    public Tab getLoginTab() {
        return loginTab;
    }

    public Tab getRegisterTab() {
        return registerTab;
    }

    public WebElement getUnregMessage() {
        return UnregMessage;
    }


}
