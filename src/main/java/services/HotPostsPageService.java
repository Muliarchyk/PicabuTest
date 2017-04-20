package services;

import com.google.inject.Provider;
import logger.LoggerManager;
import services.interfaces.IHotPostsPageService;
import weblayer.elements.CButton;
import weblayer.elements.Post;
import weblayer.pages.postsTabs.HotPostsPage;

import javax.inject.Inject;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public class HotPostsPageService implements IHotPostsPageService {
    @Inject
    private Provider<HotPostsPage> hotPostsPageProvider;

    protected HotPostsPage getPage(){
        return hotPostsPageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        CButton sortByDay = getPage().getSortByDay();
        CButton sortByRelevance = getPage().getSortByRelevance();
        CButton viewMod = getPage().getViewMod();
        if(sortByDay.isDisplayed()
                & sortByRelevance.isDisplayed()
                & viewMod.isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Page with hot posts is open.");
            return true;
        }else {
            LoggerManager.getInstance().getLogger().info("Page with hot posts does not contain all items!");
            return false;
        }
    }

    @Override
    public Post getPost(int index) {
        return getPage().getPost(index);
    }

    @Override
    public Post getPostbySubstringInTitle(String substring) {
        return getPage().getPostBySubStringInTitle(substring);
    }

    @Override
    public void hidePost(int index){
        getPost(index).hidePost();
        LoggerManager.getInstance().getLogger().info("Hide post with title: "+getPost(0).getTitle().getText());
    }

    @Override
    public void hidePost(String substring) {
        getPostbySubstringInTitle(substring).hidePost();
        LoggerManager.getInstance().getLogger().info("Hide post with title: "+getPost(0).getTitle().getText());
    }

    @Override
    public void openPost(int index) {
        getPost(index).open();
        LoggerManager.getInstance().getLogger().info("Open post with title: "+getPost(0).getTitle().getText());
    }

    @Override
    public void openPost(String substring) {
        getPostbySubstringInTitle(substring).open();
        LoggerManager.getInstance().getLogger().info("Open post with title: "+getPost(0).getTitle().getText());
    }

    @Override
    public boolean isPostContentDisplay(int index) {
        if (getPost(index).postContent().isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Post content displayed. Post title: "+getPost(0).getTitle().getText());
            return true;
        } else {
            LoggerManager.getInstance().getLogger().info("Post content is not displayed. Post title: "+getPost(0).getTitle().getText());
            return false;
        }
    }

    @Override
    public boolean isPostContentDisplay(String substring) {
        if (getPostbySubstringInTitle(substring).postContent().isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Post content displayed. Post title: "+getPost(0).getTitle().getText());
            return true;
        } else {
            LoggerManager.getInstance().getLogger().info("Post content is not displayed. Post title: "+getPost(0).getTitle().getText());
            return false;
        }
    }

}
