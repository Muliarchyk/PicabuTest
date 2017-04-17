package services.interfaces;

import weblayer.elements.Post;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public interface IRecentPostPageService {
    boolean isPageShown();

    Post getPost(int index);
    Post getPostbySubstringInTitle(String substring);
}
