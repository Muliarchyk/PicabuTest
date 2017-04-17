package weblayer.elements;

import logger.LoggerManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

/**
 * Created by Andrei_Muliarchyk on 3/29/2017.
 */
public class CButton extends CustomElement {
    public CButton(WebElement wrappedElement) {
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
    public String getText(){
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
