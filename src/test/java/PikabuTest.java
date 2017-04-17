
import core.ConfigurationManager;
import core.VerifyManager;
import logger.LoggerManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import weblayer.elements.Post;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */

public class PikabuTest extends BaseTest{

    @Test(description = "Login with valid values",enabled = false)
    public void loginTest() {
        LoggerManager.getInstance().getLogger().info("Login test");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.openLoginTab();
        VerifyManager.getInstance().isTrue(loginService.isPageShown(),"Login page does not contain all items","Login page is open");
        LoggerManager.getInstance().getLogger().info("Input in LoginField value - " + ConfigurationManager.getInstance().getAUTHORIZATION_LOGIN());
        loginService.inputLogin(ConfigurationManager.getInstance().getAUTHORIZATION_LOGIN());
        LoggerManager.getInstance().getLogger().info("Input in PasswordField value - " + ConfigurationManager.getInstance().getAUTHORIZATION_PASSWORD());
        loginService.inputPassword(ConfigurationManager.getInstance().getAUTHORIZATION_PASSWORD());
        LoggerManager.getInstance().getLogger().info("Click submit button");
        loginService.clickSubmit();
        Assert.assertEquals(profilePageService.isPageShown(),true,"Profile page is not opened");
        LoggerManager.getInstance().getLogger().info("Profile page is opened. Login is successful");

        VerifyManager.getInstance().getAsserter().assertAll();

    }
    @Test(description = "login with google account")
    public void loginWithGoogleAccount(){
        LoggerManager.getInstance().getLogger().info("Login with google account test");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.openLoginTab();
        VerifyManager.getInstance().isTrue(loginService.isPageShown(),"Login page does not contain all items","Login page is open");
        loginService.loginWithGoogleAccount();
        LoggerManager.getInstance().getLogger().info("Input in email field value - " + ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_EMAIL());
        authorizationByGoogleService.inputEmail(ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_EMAIL());
        LoggerManager.getInstance().getLogger().info("Click next");
        authorizationByGoogleService.clickNext();
        LoggerManager.getInstance().getLogger().info("Input in password field value - " + ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_PASSWORD());
        authorizationByGoogleService.inputPassword(ConfigurationManager.getInstance().getGOOGLE_AUTHORIZATION_PASSWORD());
        LoggerManager.getInstance().getLogger().info("Click submit button");
        authorizationByGoogleService.clickSubmit();
        Assert.assertEquals(profilePageService.isPageShown(),true,"Profile page is not opened");
        LoggerManager.getInstance().getLogger().info("Profile page is opened. Login is successful");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Test of improving the rating of the post on the page with best posts",enabled = false)
    public void postRatingUp (){
        LoggerManager.getInstance().getLogger().info("Post rating up");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.openLoginTab();
        VerifyManager.getInstance().isTrue(loginService.isPageShown(),"Login page does not contain all items","Login page is open");
//        if (!isLoginComplete){
//            loginService.loginWithGoogleAccount();
//            LoggerManager.info("Input email");
//            authorizationByGoogleService.inputEmail("muliarchyk.a.a@gmail.com");
//            LoggerManager.info("Click next");
//            authorizationByGoogleService.clickNext();
//            LoggerManager.info("Input password");
//            authorizationByGoogleService.inputPassword("life2008");
//            LoggerManager.info("Click submit");
//            authorizationByGoogleService.clickSubmit();
//        }else {
//            loginService.loginWithGoogleAccount();
//        }
        LoggerManager.getInstance().getLogger().info("Input in LoginField value - " + ConfigurationManager.getInstance().getAUTHORIZATION_LOGIN());
        loginService.inputLogin(ConfigurationManager.getInstance().getAUTHORIZATION_LOGIN());
        LoggerManager.getInstance().getLogger().info("Input in PasswordField value - " + ConfigurationManager.getInstance().getAUTHORIZATION_PASSWORD());
        loginService.inputPassword(ConfigurationManager.getInstance().getAUTHORIZATION_PASSWORD());
        LoggerManager.getInstance().getLogger().info("Click submit button");
        loginService.clickSubmit();
        VerifyManager.getInstance().isTrue(profilePageService.isPageShown(),"Profile page does not contain all items","Profile page is open");
        mainPageService.openBestPostsTab();
        VerifyManager.getInstance().isTrue(bestPostPageService.isPageShown(),"Page with best posts does not contain all items","Page with best posts is open");
        int ratingBefore =Integer.parseInt(bestPostPageService.getPost(0).postRatingCount().getText());
        LoggerManager.getInstance().getLogger().info("Rating up");
        bestPostPageService.getPost(0).postRatingUp().click();
        int ratingAfter = Integer.parseInt(bestPostPageService.getPost(0).postRatingCount().getText());
        LoggerManager.getInstance().getLogger().info("Rating down");
        bestPostPageService.getPost(0).postRatingDown().click();
        Assert.assertEquals((ratingBefore + 1 )== ratingAfter,true,"Rating has not increased");
        LoggerManager.getInstance().getLogger().info("Rating up is successful");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Adding a post for a non-login user")
    public void addPostWithUnregUser(){
        LoggerManager.getInstance().getLogger().info("Add a post for a non-login user");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.clickAddPostButton();
        LoggerManager.getInstance().getLogger().info("Add post button is clicked");
        Assert.assertEquals(mainPageService.isUnregMessageShow(),true,"Message about an unregistered user is not displayed");
        LoggerManager.getInstance().getLogger().info("Message about an unregistered user is displayed");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Verify page with best posts")
    public void verifyBestPostPage(){
        LoggerManager.getInstance().getLogger().info("Verify page with best posts");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.openLoginTab();
        mainPageService.openBestPostsTab();
        Assert.assertEquals(bestPostPageService.isPageShown(),true,"Page with best posts is not opened");
        LoggerManager.getInstance().getLogger().info("Page with best posts is opened");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Verify page with hot posts")
    public void verifyHotPostsPage(){
        LoggerManager.getInstance().getLogger().info("Verify page with hot posts");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.openHotPostsTab();
        Assert.assertEquals(hotPostsPageService.isPageShown(),true,"Page with hot posts is not opened");
        LoggerManager.getInstance().getLogger().info("Page with hot posts is opened");

        VerifyManager.getInstance().getAsserter().assertAll();
    }
    @Test(description = "Verify page with recent posts")
    public void verifyRecentPostsPage(){
        LoggerManager.getInstance().getLogger().info("Verify page with recent posts");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        mainPageService.openRecentPostTab();
        Assert.assertEquals(recentPostPageService.isPageShown(),true,"Page with recent posts is not opened");
        LoggerManager.getInstance().getLogger().info("Page with recent posts is opened");

        VerifyManager.getInstance().getAsserter().assertAll();
    }

    @Test(description = "Search test")
    public void searchTest(){
        boolean isAllElementsContainsHashTags = true;
        String searchQuery = "ДТП";
        LoggerManager.getInstance().getLogger().info("Search test");
        VerifyManager.getInstance().isTrue(mainPageService.isPageShown(),"Main page does not contain all items","Main page is open");
        LoggerManager.getInstance().getLogger().info("input query in search field. Value = "+searchQuery);
        mainPageService.inputInSearchField(searchQuery);
        LoggerManager.getInstance().getLogger().info("Click search button");
        mainPageService.clickSearchButton();
        VerifyManager.getInstance().isTrue(searchResultPageService.isPageShown(),"Page with search result does not contain all items","Page with search result is open");
        LoggerManager.getInstance().getLogger().info("Verify search results");
        List<Post> posts = searchResultPageService.getPostsList();
        for (int i=0;i<posts.size()-1;i++){
            boolean isContainsHashtag = false;
            for (WebElement hashtag:posts.get(i).getHashtagsList()){
                if(hashtag.getText().contains(searchQuery)){
                    isContainsHashtag = true;
                    break;
                }
            }
            if(!isContainsHashtag){
                isAllElementsContainsHashTags = false;
                LoggerManager.getInstance().getLogger().warn("Post with title '"+searchResultPageService.getPostsList().get(i).getTitle().getText()+"' is not contains hashtag");
            }
        }
        Assert.assertEquals(isAllElementsContainsHashTags,true,"Some posts do not contain hashtag");

        VerifyManager.getInstance().getAsserter().assertAll();
    }

}
