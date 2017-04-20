package weblayer.elements;

import logger.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class Post extends CustomElement {
    public Post(WebElement wrappedElement) {
        super(wrappedElement);
    }

    //Post title
    public WebElement getTitle(){
        return getWrappedElement().findElement(By.xpath(".//a[contains(@class,'story__title')]"));
    }
    //Post comments
    public WebElement getComments(){
        return getWrappedElement().findElement(By.xpath(".//a[contains(@class,'comments')]"));
    }
    //Post hashtagsList
    public List<WebElement> getHashtagsList(){
        return getWrappedElement().findElements(By.xpath(".//a[@class='story__tag']"));
    }
    //Post hashtag
    public WebElement getHashtag(int index){
        return getHashtagsList().get(index);
    }
    //Save post
    public WebElement savePost(){
        return getWrappedElement().findElement(By.xpath(".//div[contains(@class,'save')]"));
    }
    //Rating up
    public WebElement postRatingUp(){
        return getWrappedElement().findElement(By.xpath(".//div[@class='story__rating-up']"));
    }
    //Rating count
    public WebElement postRatingCount(){
        return getWrappedElement().findElement(By.xpath(".//div[@class='story__rating-count']"));
    }
    //Rating down
    public WebElement postRatingDown(){
        return getWrappedElement().findElement(By.xpath(".//div[@class='story__rating-down']"));
    }
    public WebElement hidePostButton(){
        return getWrappedElement().findElement(By.xpath(".//div[contains(@class,'story__slide-up')]"));
    }
    public WebElement postContent(){
        return getWrappedElement().findElement(By.xpath(".//div[contains(@class,'story__wrapper')]"));
    }

    public void hidePost(){
        hidePostButton().click();
    }
    public void open(){
        getTitle().click();
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
