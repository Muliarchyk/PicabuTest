package weblayer.elements;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 * Created by Andrei_Muliarchyk on 3/29/2017.
 */
public abstract class CustomElement extends TypifiedElement {

    protected CustomElement(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public boolean isExist() {
        try {
            getNotProxiedElement();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public WebElement getNotProxiedElement() {
        WebElement wrappedElement = getWrappedElement();

        while (wrappedElement instanceof WrapsElement) {
            wrappedElement = ((WrapsElement) wrappedElement).getWrappedElement();
        }
        return wrappedElement;
    }
}
