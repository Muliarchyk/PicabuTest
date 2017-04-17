package weblayer.pages.core;

import logger.LoggerManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import weblayer.elements.Post;

import java.util.List;

/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class TabWithPosts extends BasePage {

    @FindAll(@FindBy(xpath = "//div[@class = 'story']"))
    private List<Post> posts;

    public List<Post> getPostsList(){
        return posts;
    }
    public Post getPost(int index) {
        return posts.get(index);
    }

    public Post getPostBySubStringInTitle(String substring){
        Post post = null;
            for (Post x:posts) {
                if (x.getTitle().getText().contains(substring)){
                    post = x;
                }
            }
            if (post == null) {
                LoggerManager.getInstance().getLogger().error("Post with substring -'"+substring+"' not found");
                throw new NoSuchElementException("Post with substring -'"+substring+"' not found");
            }

        return post;
    }
}
