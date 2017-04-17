package services.interfaces;

import ru.yandex.qatools.htmlelements.element.Button;

/**
 * Created by Andrei_Muliarchyk on 3/27/2017.
 */
public interface IProfilePageService {
    boolean isPageShown();

    void openProfile();
    void openNotification();
    void logout();
    void editProfile();
    void openUserList();
    void openUserPosts();
    void openUserMessages();
    void openComments();
    void openMarkedPosts();
    void openSavedPosts();

    String  getUserListCount();
    String getUserRating();
    String getUserSubscribers();
}
