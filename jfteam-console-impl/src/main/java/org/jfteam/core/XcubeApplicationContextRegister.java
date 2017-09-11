package org.jfteam.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by fengwenping on 2017/3/14.
 */
public class XcubeApplicationContextRegister implements ApplicationContextAware {
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        XcubeApplicationContext xcubeApplicationContext = new XcubeApplicationContext(applicationContext);
        Xcube.setContext(xcubeApplicationContext);
    }
}
