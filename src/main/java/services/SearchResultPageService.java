package services;

import com.google.inject.Provider;
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
            return true;
        }else {
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
}
