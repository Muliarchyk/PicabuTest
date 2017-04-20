package weblayer.elements;

import logger.LoggerManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

/**
 * Created by Andrei_Muliarchyk on 3/29/2017.
 */
public class Input extends CustomElement {
    public Input(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public void clear() {
        if(!isExist()){
            LoggerManager.getInstance().getLogger().error("'" + this.toString() + "' NOT FOUND!");
            throw new NotFoundException("'" + this.toString() + "' NOT FOUND!");
        } else {
            getWrappedElement().clear();
        }
    }

    public void sendKeys(CharSequence... keys) {
        if(!isExist()){
            LoggerManager.getInstance().getLogger().error("'" + this.toString() + "' NOT FOUND!");
            throw new NotFoundException("'" + this.toString() + "' NOT FOUND!");
        } else {
            getWrappedElement().sendKeys(keys);
        }
    }

    public String getEnteredText() {
        if(!isExist()){
            LoggerManager.getInstance().getLogger().error("'" + this.toString() + "' NOT FOUND!");
            throw new NotFoundException("'" + this.toString() + "' NOT FOUND!");
        } else {
        return getText();
        }
    }

    public String getText() {
        if("textarea".equals(getWrappedElement().getTagName())) {
            throw new NotFoundException("'" + this.toString() + "' NOT FOUND!");
        } else {
            String enteredText = getWrappedElement().getAttribute("value");
            return enteredText == null?"":enteredText;
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

