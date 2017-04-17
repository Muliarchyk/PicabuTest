package services.interfaces;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public interface IMainPageService {
    boolean isPageShown();

    void inputInSearchField(String query);
    void clickSearchButton();
    void clickAddPostButton();
    void openHotPostsTab();
    void openBestPostsTab();
    void openRecentPostTab();
    void openCommunitiesPostTab();
    void openLoginTab();
    void openRegisterTab();
    boolean isUnregMessageShow();

}
