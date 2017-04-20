
import core.ConfigurationManager;
import core.DriverManager;
import core.VerifyManager;
import logger.LoggerManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import services.HotPostsPageService;
import weblayer.elements.Post;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */

public class PikabuTest extends BaseTest{

    @Test(description = "Login with valid values",enabled = false)
    public void loginTest() {
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openLoginTab();
        VerifyManager.getInstance().isTrue(loginService.isPageShown());
        loginService.inputLogin(ConfigurationManager.getInstance().getAUTHORIZATION_LOGIN());
        loginService.inputPassword(ConfigurationManager.getInstance().getAUTHORIZATION_PASSWORD());
        loginService.clickSubmit();
        Assert.assertEquals(profilePageService.isPageShown(),true);

        VerifyManager.getInstance().getAsserter().assertAll();

    }
    @Test(description = "login with google account")
    public void loginWithGoogleAccount(){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openLoginTab();
        VerifyManager.getInstance().isTrue(loginService.isPageShown());
        loginService.clickGoogleAccountButton();
        authorizationByGoogleService.inputEmail(ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_EMAIL());
        authorizationByGoogleService.clickNext();
        authorizationByGoogleService.inputPassword(ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_PASSWORD());
        authorizationByGoogleService.clickSubmit();
        Assert.assertEquals(profilePageService.isPageShown(),true,"Login with google account is fail!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Test of increased the rating of the post on the page with best posts")
    public void postRatingUp (){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openLoginTab();
        VerifyManager.getInstance().isTrue(loginService.isPageShown());
        loginService.clickGoogleAccountButton();
        authorizationByGoogleService.inputEmail(ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_EMAIL());
        authorizationByGoogleService.clickNext();
        authorizationByGoogleService.inputPassword(ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_PASSWORD());
        authorizationByGoogleService.clickSubmit();
        VerifyManager.getInstance().isTrue(profilePageService.isPageShown());
        mainPageService.openBestPostsTab();
        VerifyManager.getInstance().isTrue(bestPostPageService.isPageShown());
        int ratingBefore =Integer.parseInt(bestPostPageService.getPost(0).postRatingCount().getText());
        bestPostPageService.getPost(0).postRatingUp().click();
        int ratingAfter = Integer.parseInt(bestPostPageService.getPost(0).postRatingCount().getText());
        bestPostPageService.getPost(0).postRatingDown().click();
        Assert.assertEquals((ratingBefore + 1 )== ratingAfter,true,"Rating in not increase!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Adding a post for a non-login user")
    public void addPostWithUnregUser(){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.clickAddPostButton();
        Assert.assertEquals(mainPageService.isUnregMessageShow(),true,"Message about login via non-register user isn't display!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Verify page with best posts")
    public void verifyBestPostPage(){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openBestPostsTab();
        Assert.assertEquals(bestPostPageService.isPageShown(),true,"Page with best posts isn't open!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Verify page with hot posts")
    public void verifyHotPostsPage(){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openHotPostsTab();
        Assert.assertEquals(hotPostsPageService.isPageShown(),true,"Page with hot posts isn't open!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Verify page with recent posts")
    public void verifyRecentPostsPage(){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openRecentPostTab();
        Assert.assertEquals(recentPostPageService.isPageShown(),true,"page with recent posts isn't open!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }

    @Test(description = "Search test")
    public void searchTest(){
        String searchQuery = "ДТП";
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.inputInSearchField(searchQuery);
        mainPageService.clickSearchButton();
        VerifyManager.getInstance().isTrue(searchResultPageService.isPageShown());
        Assert.assertEquals(searchResultPageService.verifySearchResult(searchQuery),true,"Search test is fail!");

        VerifyManager.getInstance().getAsserter().assertAll();
    }

    @Test(description = "Post hide test")
    public void postHideTest(){
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown());
        mainPageService.openHotPostsTab();
        VerifyManager.getInstance().isTrue(hotPostsPageService.isPageShown());
        hotPostsPageService.hidePost(0);
        Assert.assertEquals(hotPostsPageService.isPostContentDisplay(0),false,"Post is not hide");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
}
