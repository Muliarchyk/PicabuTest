package weblayer.pages.postsTabs;

import org.openqa.selenium.support.FindBy;
import weblayer.elements.CButton;
import weblayer.pages.core.TabWithPosts;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class BestPostsPage extends TabWithPosts {
    private final String xpath = "//div[@class = 'b-feed-panel__toolbar']";

    @FindBy(xpath = xpath+"//a[@data-type = 'date']")
    private CButton sortByDay;
    @FindBy(xpath = xpath+"//a[@data-type = 'mode']")
    private CButton viewMod;

    public CButton getSortByDay() {
        return sortByDay;
    }

    public CButton getViewMod() {
        return viewMod;
    }

}
