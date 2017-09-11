package org.jfteam.core;

/**
 * Hello world!
 */
public class Xcube {
    private static XcubeApplicationContext applicationContext;

    public static void setContext(XcubeApplicationContext xcubeApplicationContext){
        applicationContext = xcubeApplicationContext;
    }

    public static XcubeApplicationContext getContext(){
        return applicationContext;
    }
}
