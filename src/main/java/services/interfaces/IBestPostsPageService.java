package services.interfaces;

import weblayer.elements.Post;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public interface IBestPostsPageService {
    boolean isPageShown();

    Post getPost(int index);
    Post getPostbySubstringInTitle(String substring);
}
