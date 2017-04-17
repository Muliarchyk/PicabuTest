package services;

import com.google.inject.Provider;
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
