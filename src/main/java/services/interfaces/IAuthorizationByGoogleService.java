package services.interfaces;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public interface IAuthorizationByGoogleService {

    void inputEmail(String email);
    void inputPassword(String password);
    void clickNext();
    void clickSubmit();
}
