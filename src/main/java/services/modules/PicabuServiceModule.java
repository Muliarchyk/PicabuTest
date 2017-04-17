package services.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import services.*;
import services.interfaces.*;

/**
 * Created by Andrei_Muliarchyk on 3/24/2017.
 */
public class PicabuServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ILoginService.class).to(LoginService.class).in(Scopes.SINGLETON);
        bind(IMainPageService.class).to(MainPageService.class).in(Scopes.SINGLETON);
        bind(IProfilePageService.class).to(ProfilePageService.class).in(Scopes.SINGLETON);
        bind(IBestPostsPageService.class).to(BestPostsPageService.class).in(Scopes.SINGLETON);
        bind(ISearchResultPageService.class).to(SearchResultPageService.class).in(Scopes.SINGLETON);
        bind(IHotPostsPageService.class).to(HotPostsPageService.class).in(Scopes.SINGLETON);
        bind(IRecentPostPageService.class).to(RecentPostPageService.class).in(Scopes.SINGLETON);
        bind(IAuthorizationByGoogleService.class).to(AuthorizationByGoogleService.class).in(Scopes.SINGLETON);
    }
}
