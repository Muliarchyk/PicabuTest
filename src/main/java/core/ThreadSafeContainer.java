package core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrei_Muliarchyk on 4/7/2017.
 */
public class ThreadSafeContainer<T> {
    private Map<Long, T> container = new HashMap<>();

    public synchronized T getInstance() {
        return container.get(Thread.currentThread().getId());
    }

    public synchronized boolean containsCurrentThread(){
        return container.containsKey(Thread.currentThread().getId());
    }

    public synchronized void set(T instance) {
            container.put(Thread.currentThread().getId(), instance);
    }

    public synchronized void clearContainer(){
        container.clear();
    }
}
