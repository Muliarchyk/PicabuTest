package weblayer.elements;

import logger.LoggerManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class Tab extends CustomElement {

    public Tab(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click(){
        if (!isExist()) {
            LoggerManager.getInstance().getLogger().error("'" + this.toString() + "' NOT FOUND!");
            throw new NotFoundException("'" + this.toString() + "' NOT FOUND!");
        }else {
            getWrappedElement().click();
        }
    }

    public String getTitle(){
        if(!isExist()){
            LoggerManager.getInstance().getLogger().error("'" + this.toString() + "' NOT FOUND!");
            throw new NotFoundException("'" + this.toString() + "' NOT FOUND!");
        }else {
            return getWrappedElement().getText();
        }
    }

    public boolean isDisplayed(){
        if(!isExist()){
            LoggerManager.getInstance().getLogger().error("'" + this.toString() + "' NOT FOUND!");
            return false;
        }else {
            return getWrappedElement().isDisplayed();
        }
    }
}
