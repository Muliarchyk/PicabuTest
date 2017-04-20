package services;

import com.google.inject.Inject;
import com.google.inject.Provider;
import logger.LoggerManager;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import services.interfaces.IMainPageService;
import weblayer.elements.CButton;
import weblayer.elements.Input;
import weblayer.elements.Tab;
import weblayer.pages.MainPage;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public class MainPageService implements IMainPageService {
    @Inject
    private Provider<MainPage> mainPageProvider;

    protected MainPage getPage(){
       return mainPageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        Input searchField = getPage().getSearchField();
        CButton searchButton = getPage().getSearchButton();
        CButton addPostButton = getPage().getAddPostButton();
        Tab hotPostsTab = getPage().getHotPostsTab();
        Tab bestPostsTab = getPage().getBestPostsTab();
        Tab recentPostsTab = getPage().getRecentPostsTab();
        Tab communitiesPostsTab = getPage().getCommunitiesPostsTab();
        Tab loginTab = getPage().getLoginTab();
        Tab registerTab = getPage().getRegisterTab();

        if(searchField.isDisplayed()
                & searchButton.isDisplayed()
                & addPostButton.isDisplayed()
                & hotPostsTab.isDisplayed()
                & bestPostsTab.isDisplayed()
                & recentPostsTab.isDisplayed()
                & communitiesPostsTab.isDisplayed()
                & loginTab.isDisplayed()
                & registerTab.isDisplayed()
                ){
            LoggerManager.getInstance().getLogger().info("Main page is open.");
            return true;
        } else{
            LoggerManager.getInstance().getLogger().info("Main page does not contain all items!");
        } return false;
    }

    @Override
    public void inputInSearchField(String query) {
        getPage().getSearchField().sendKeys(query);
        LoggerManager.getInstance().getLogger().info("The value '"+query+"'is entered in the search field");
    }

    @Override
    public void clickSearchButton() {
        getPage().getSearchButton().click();
        LoggerManager.getInstance().getLogger().info("Search button clicked.");
    }

    @Override
    public void clickAddPostButton() {
        getPage().getAddPostButton().click();
        LoggerManager.getInstance().getLogger().info("Add post button clicked.");
    }

    @Override
    public void openHotPostsTab() {
        getPage().getHotPostsTab().click();
        LoggerManager.getInstance().getLogger().info("Hot posts tab clicked.");
    }

    @Override
    public void openBestPostsTab() {
        getPage().getBestPostsTab().click();
        LoggerManager.getInstance().getLogger().info("Best posts tab clicked.");
    }

    @Override
    public void openRecentPostTab() {
        getPage().getRecentPostsTab().click();
        LoggerManager.getInstance().getLogger().info("Recent posts tab clicked.");
    }

    @Override
    public void openCommunitiesPostTab() {
        getPage().getCommunitiesPostsTab().click();
        LoggerManager.getInstance().getLogger().info("Communities posts tab clicked.");
    }

    @Override
    public void openLoginTab() {
        getPage().getLoginTab().click();
        LoggerManager.getInstance().getLogger().info("Login tab clicked.");
    }

    @Override
    public void openRegisterTab() {
        getPage().getRegisterTab().click();
        LoggerManager.getInstance().getLogger().info("Register tab clicked.");
    }

    @Override
    public boolean isUnregMessageShow() {
        if (getPage().getUnregMessage().isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Message about an unregistered user is displayed.");
            return true;
        } else{
            LoggerManager.getInstance().getLogger().info("Message about an unregistered user is not displayed.");
            return false;
        }

    }

}
