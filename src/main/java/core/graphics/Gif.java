package core.graphics;

import core.ThreadSafeContainer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Muliarchyk on 4/17/2017.
 */
public class Gif {
    private static Gif instance;
    private ThreadSafeContainer<List<File>> gif = new ThreadSafeContainer<>();
    public static synchronized Gif getInstance(){
        if (instance == null){
            instance = new Gif();
        }
        return instance;
    }
    public void addImage(File screanshot){
        if (!gif.containsCurrentThread()){
            gif.set(new ArrayList<>());
        }
        gif.getInstance().add(screanshot);
    }
}
