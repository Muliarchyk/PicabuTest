package services;

import com.google.inject.Provider;
import logger.LoggerManager;
import org.openqa.selenium.WebElement;
import services.interfaces.ISearchResultPageService;
import weblayer.elements.Input;
import weblayer.elements.Post;
import weblayer.pages.postsTabs.SearchResultPage;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andrei_Muliarchyk on 3/30/2017.
 */
public class SearchResultPageService implements ISearchResultPageService{
    @Inject
    private Provider<SearchResultPage> searchResultPageProvider;

    protected SearchResultPage getPage(){
        return searchResultPageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        Input searchQuery = getPage().getSearchQuery();
        if(searchQuery.isDisplayed()){
            LoggerManager.getInstance().getLogger().info("Page with search results is open.");
            return true;
        }else {
            LoggerManager.getInstance().getLogger().info("Page with search results does not contain all items!");
            return false;
        }
    }

    @Override
    public List<Post> getPostsList() {
        return getPage().getPostsList();
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
    public List<WebElement> getHashtags(Post post) {
        return post.getHashtagsList();
    }

    @Override
    public boolean verifySearchResult(String query) {
        boolean isAllElementsContainsHashTags = true;
        List<Post> posts = getPostsList();
        for (int i=0;i<posts.size()-1;i++){
            boolean isContainsHashtag = false;
            for (WebElement hashtag:posts.get(i).getHashtagsList()){
                if(hashtag.getText().contains(query)){
                    isContainsHashtag = true;
                    break;
                }
            }
            if(!isContainsHashtag){
                isAllElementsContainsHashTags = false;
                LoggerManager.getInstance().getLogger().warn("Post with title '"+posts.get(i).getTitle().getText()+"' is not contains hashtag");
            }
        }
        return isAllElementsContainsHashTags;
    }
}
