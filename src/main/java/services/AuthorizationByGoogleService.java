package services;

import com.google.inject.Provider;
import services.interfaces.IAuthorizationByGoogleService;
import weblayer.pages.authorizationby.AuthorizationByGoogle;

import javax.inject.Inject;

/**
 * Created by Andrei_Muliarchyk on 3/31/2017.
 */
public class AuthorizationByGoogleService implements IAuthorizationByGoogleService {
    @Inject
    private Provider<AuthorizationByGoogle> authorizationByGoogleProvider;

    protected AuthorizationByGoogle getPage(){
        return authorizationByGoogleProvider.get();
    }
    @Override
    public void inputEmail(String email) {
        getPage().getGoogleEmail().sendKeys(email);
    }

    @Override
    public void inputPassword(String password) {
        getPage().getGooglePassword().sendKeys(password);
    }

    @Override
    public void clickNext() {
        getPage().getGoogleNext().click();
    }

    @Override
    public void clickSubmit() {
        getPage().getGoogleSubmit().click();
    }
}
