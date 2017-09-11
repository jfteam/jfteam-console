package org.jfteam.core.event;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengwenping on 2017/3/17.
 * 抽象的事件参数
 */
public abstract class AbstractEventArgs implements IEventArgs {

    private Map<String, Object> contexts = new HashMap<String, Object>();

    public void put(String key, Object value) {
        contexts.put(key, value);
    }

    public Object getValue(String key) {
        return contexts.get(key);
    }
}
