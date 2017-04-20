package services;

import com.google.inject.Inject;
import com.google.inject.Provider;
import logger.LoggerManager;
import services.interfaces.IProfilePageService;
import weblayer.elements.CButton;
import weblayer.elements.Label;
import weblayer.pages.ProfilePage;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public class ProfilePageService implements IProfilePageService {
    @Inject
    private Provider<ProfilePage> profilePageProvider;

    protected ProfilePage getPage(){
        return profilePageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        CButton userName = getPage().getUserName();
        CButton userNotification = getPage().getUserNotification();
        CButton logout = getPage().getLogout();
        Label userRating = getPage().getUserRating();
        Label userSubscriber = getPage().getUserSubscriber();
        CButton editUserProfile = getPage().getEditUserProfile();
        CButton userList = getPage().getUserList();
        CButton userPosts = getPage().getUserPosts();
        CButton userMessages = getPage().getUserMessages();
        CButton userComments = getPage().getUserComments();
        CButton userMarks = getPage().getUserMarks();
        CButton userSavedPosts = getPage().getUserSavedPosts();
        if (userName.isDisplayed()
                & userNotification.isDisplayed()
                & logout.isDisplayed()
                & userRating.isDisplayed()
                & userSubscriber.isDisplayed()
                & editUserProfile.isDisplayed()
                & userList.isDisplayed()
                & userPosts.isDisplayed()
                & userMessages.isDisplayed()
                & userComments.isDisplayed()
                & userMarks.isDisplayed()
                & userSavedPosts.isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Profile page is open.");
            return true;
        } else{
            LoggerManager.getInstance().getLogger().info("Profile page does not contain all items!");
            return false;
        }
    }

    @Override
    public void openProfile() {
        getPage().getUserName().click();
        LoggerManager.getInstance().getLogger().info("Profile button clicked.");
    }

    @Override
    public void openNotification() {
        getPage().getUserNotification().click();
        LoggerManager.getInstance().getLogger().info("Notification button clicked.");
    }

    @Override
    public void logout() {
        getPage().getLogout().click();
        LoggerManager.getInstance().getLogger().info("Logout button clicked.");
    }

    @Override
    public String getUserRating() {
        return  getPage().getUserRating().getText();
    }

    @Override
    public String getUserSubscribers() {
        return getPage().getUserSubscriber().getText();
    }

    @Override
    public void editProfile() {
        getPage().getEditUserProfile().click();
        LoggerManager.getInstance().getLogger().info("Edit profile button clicked.");
    }

    @Override
    public void openUserList() {
        getPage().getUserList().click();
        LoggerManager.getInstance().getLogger().info("User list button clicked.");
    }

    @Override
    public String getUserListCount() {
        return getPage().getUserListCount().getName();
    }

    @Override
    public void openUserPosts() {
        getPage().getUserPosts().click();
        LoggerManager.getInstance().getLogger().info("User posts button clicked.");
    }

    @Override
    public void openUserMessages() {
        getPage().getUserMessages().click();
        LoggerManager.getInstance().getLogger().info("User messages button clicked.");
    }

    @Override
    public void openComments() {
        getPage().getUserComments().click();
        LoggerManager.getInstance().getLogger().info("Comments button clicked.");
    }

    @Override
    public void openMarkedPosts() {
        getPage().getUserMarks().click();
        LoggerManager.getInstance().getLogger().info("Marked posts button clicked.");
    }

    @Override
    public void openSavedPosts() {
        getPage().getUserSavedPosts().click();
        LoggerManager.getInstance().getLogger().info("Saver posts button clicked.");
    }
}
