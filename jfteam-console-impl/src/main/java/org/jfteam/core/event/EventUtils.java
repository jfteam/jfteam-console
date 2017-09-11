package org.jfteam.core.event;

import org.jfteam.core.Xcube;
import org.jfteam.core.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by fengwenping on 2017/3/15.
 *
 * 模拟spring的事件模型进行驱动
 */
public final class EventUtils {

    private EventUtils(){}

    private static final Logger logger = LoggerFactory.getLogger(EventUtils.class);

    private static Map<String ,Object> handlerCache = new HashMap<String, Object>();

    public static <T extends IEventHandler<E>, E extends IEventArgs> int dispatch(Class<T> handlerClass){
        try {
            return dispatch(handlerClass, null, null, true);
        }catch (Exception exp){
            logger.error("EventUtil.dispatch(Class<T> handlerClass)", exp);
            return 0;
        }
    }

    private static <T extends IEventHandler<E>, E extends IEventArgs> int dispatch(Class<T> handlerClass, Object sender, E args) {
        try {
            return dispatch(handlerClass, sender, args, true);
        }catch (Exception exp){
            logger.error("EventUtil.dispatch(Class<T> handlerClass, Object sender, E args)", exp);
            return 0;
        }
    }

    public static <T extends IEventHandler<E>, E extends IEventArgs> int dispatch(Class<T> handlerClass, Object sender, E args, boolean ignoreError) throws ApplicationException {
        List<T> handlerList = new ArrayList<T>();

        String handlerName = handlerClass.getName();
        Object cachedHandlers = handlerCache.get(handlerName);
        if (cachedHandlers != null){
            handlerList = getBeansOfType(handlerClass);
            handlerCache.put(handlerName, handlerList);
        }
        if (CollectionUtils.isEmpty(handlerList)){
            return 0;
        }
        for (IEventHandler<E> handler: handlerList){
            logger.info("Before execute event handler:{0}", handlerName);
            if (!ignoreError){
                handler.execute(sender, args);
                continue;
            }
            //忽略错误,则发生错误时仅记录日志
            try {
                handler.execute(sender, args);
            }catch (Exception exp){
                logger.error("EventUtil.dispatch(Class<T> handlerClass, Object sender, E args, boolean ignoreError)", exp);
            }
        }
        return handlerList.size();
    }

    private static <T> List<T> getBeansOfType(Class<T> handlerClass){
        List handlerList;
        Map<String, T> handlerMap = Xcube.getContext().getBeansOfType(handlerClass);
        handlerList = CollectionUtils.arrayToList(handlerMap);
        if (IOrder.class.isAssignableFrom(handlerClass)){
            List<IOrder> handlerOrderList = (List<IOrder>)handlerList;
            Collections.sort(handlerOrderList, new Comparator<IOrder>() {
                public int compare(IOrder o1, IOrder o2) {
                    return o1.getOrder() - o2.getOrder();
                }
            });
            handlerList = handlerOrderList;
        }
        return handlerList;
    }

}
