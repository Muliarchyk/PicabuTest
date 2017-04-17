package services.interfaces;

/**
 * Created by Andrei_Muliarchyk on 3/24/2017.
 */
public interface ILoginService {
        boolean isPageShown();

        void inputLogin(String login);
        void inputPassword(String password);
        void clickSubmit();
        void loginWithGoogleAccount();
}
