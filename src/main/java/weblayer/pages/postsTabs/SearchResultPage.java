package weblayer.pages.postsTabs;

import org.openqa.selenium.support.FindBy;
import weblayer.elements.Input;
import weblayer.pages.core.TabWithPosts;

/**
 * Created by Andrei_Muliarchyk on 3/30/2017.
 */
public class SearchResultPage extends TabWithPosts {
    @FindBy(id = "ss_text")
    private Input searchQuery;

    public Input getSearchQuery() {
        return searchQuery;
    }

}
