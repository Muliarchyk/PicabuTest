package services;

import com.google.inject.Inject;
import com.google.inject.Provider;
import services.interfaces.IBestPostsPageService;
import weblayer.elements.CButton;
import weblayer.elements.Post;
import weblayer.pages.postsTabs.BestPostsPage;

import java.util.List;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public class BestPostsPageService implements IBestPostsPageService {
    @Inject
    private Provider<BestPostsPage> bestPostsPageProvider;

    protected BestPostsPage getPage(){
        return bestPostsPageProvider.get();
    }

    @Override
    public boolean isPageShown() {
        CButton sortByDay = getPage().getSortByDay();
        CButton viewMod = getPage().getViewMod();
        List<Post> posts = getPage().getPostsList();
        if (sortByDay.isDisplayed()
                & viewMod.isDisplayed()
                & !posts.isEmpty()){
            return true;
        }else{
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
