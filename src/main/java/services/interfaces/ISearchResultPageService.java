package services.interfaces;

import org.openqa.selenium.WebElement;
import weblayer.elements.Post;

import java.util.List;

/**
 * Created by Andrei_Muliarchyk on 3/30/2017.
 */
public interface ISearchResultPageService {
    boolean isPageShown();

    List<Post> getPostsList();
    Post getPost(int index);
    Post getPostbySubstringInTitle(String substring);
    List<WebElement> getHashtags(Post post);
    boolean verifySearchResult(String query);
}
