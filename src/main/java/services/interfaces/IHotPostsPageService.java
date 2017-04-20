package services.interfaces;

import weblayer.elements.Post;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public interface IHotPostsPageService {
    boolean isPageShown();

    Post getPost(int index);
    Post getPostbySubstringInTitle(String substring);

    void hidePost(int index);
    void hidePost(String substring);
    void openPost(int index);
    void openPost(String substring);
    boolean isPostContentDisplay(int index);
    boolean isPostContentDisplay(String substring);
}
