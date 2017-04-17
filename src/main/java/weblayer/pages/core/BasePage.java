package weblayer.pages.core;

import core.DriverManager;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class BasePage {

    protected BasePage(){
        HtmlElementLoader.populatePageObject(this, DriverManager.getInstance().getDriver());
    }
}
