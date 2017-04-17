package services;

import com.google.inject.Inject;
import com.google.inject.Provider;
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
            return true;
        } else return false;
    }

    @Override
    public void inputInSearchField(String query) {
        getPage().getSearchField().sendKeys(query);
    }

    @Override
    public void clickSearchButton() {
        getPage().getSearchButton().click();
    }

    @Override
    public void clickAddPostButton() {
        getPage().getAddPostButton().click();
    }

    @Override
    public void openHotPostsTab() {
        getPage().getHotPostsTab().click();
    }

    @Override
    public void openBestPostsTab() {
        getPage().getBestPostsTab().click();
    }

    @Override
    public void openRecentPostTab() {
        getPage().getRecentPostsTab().click();
    }

    @Override
    public void openCommunitiesPostTab() {
        getPage().getCommunitiesPostsTab().click();
    }

    @Override
    public void openLoginTab() {
        getPage().getLoginTab().click();
    }

    @Override
    public void openRegisterTab() {
        getPage().getRegisterTab().click();
    }

    @Override
    public boolean isUnregMessageShow() {
        return getPage().getUnregMessage().isDisplayed();
    }

}
