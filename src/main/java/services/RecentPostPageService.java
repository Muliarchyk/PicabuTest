package services;

import com.google.inject.Provider;
import services.interfaces.IRecentPostPageService;
import weblayer.elements.CButton;
import weblayer.elements.Post;
import weblayer.pages.postsTabs.RecentPostPage;

import javax.inject.Inject;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public class RecentPostPageService implements IRecentPostPageService {
    @Inject
    private Provider<RecentPostPage> recentPostPageProvider;

    protected RecentPostPage getPage(){
        return recentPostPageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        CButton sortByDay = getPage().getSortByDay();
        CButton viewMod = getPage().getViewMod();
        if (sortByDay.isDisplayed()
                & viewMod.isDisplayed()) {
            return true;
        }else {
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
}
