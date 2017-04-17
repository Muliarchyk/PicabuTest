package weblayer.pages.postsTabs;

import org.openqa.selenium.support.FindBy;
import weblayer.elements.CButton;
import weblayer.pages.core.TabWithPosts;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class CommunitiesPostPage extends TabWithPosts {
    private final String xpath = "//div[@class = 'b-feed-panel__toolbar']";

    @FindBy(xpath = xpath+"//a[@data-type = 'community_rating']")
    private CButton sortByDay;
    @FindBy(xpath = xpath+"//a[@data-type = 'mode']")
    private CButton viewMod;

}
