package org.jfteam.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

/**
 * Created by fengwenping on 2017/3/12.
 */
public class XcubeApplicationContext implements ApplicationContext {

    private ApplicationContext delegator;

    public XcubeApplicationContext(ApplicationContext applicationContext){
        this.delegator = applicationContext;
    }

    public String getId() {
        return this.delegator.getId();
    }

    public String getApplicationName() {
        return this.delegator.getApplicationName();
    }

    public String getDisplayName() {
        return null;
    }

    public long getStartupDate() {
        return 0;
    }

    public ApplicationContext getParent() {
        return null;
    }

    public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
        return null;
    }

    public BeanFactory getParentBeanFactory() {
        return null;
    }

    public boolean containsLocalBean(String s) {
        return false;
    }

    public boolean containsBeanDefinition(String s) {
        return false;
    }

    public int getBeanDefinitionCount() {
        return 0;
    }

    public String[] getBeanDefinitionNames() {
        return new String[0];
    }

    public String[] getBeanNamesForType(ResolvableType resolvableType) {
        return new String[0];
    }

    public String[] getBeanNamesForType(Class<?> aClass) {
        return new String[0];
    }

    public String[] getBeanNamesForType(Class<?> aClass, boolean b, boolean b1) {
        return new String[0];
    }

    public <T> Map<String, T> getBeansOfType(Class<T> aClass) throws BeansException {
        return null;
    }

    public <T> Map<String, T> getBeansOfType(Class<T> aClass, boolean b, boolean b1) throws BeansException {
        return null;
    }

    public String[] getBeanNamesForAnnotation(Class<? extends Annotation> aClass) {
        return new String[0];
    }

    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> aClass) throws BeansException {
        return null;
    }

    public <A extends Annotation> A findAnnotationOnBean(String s, Class<A> aClass) throws NoSuchBeanDefinitionException {
        return null;
    }

    public Object getBean(String s) throws BeansException {
        return null;
    }

    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return null;
    }

    public <T> T getBean(Class<T> aClass) throws BeansException {
        return null;
    }

    public Object getBean(String s, Object... objects) throws BeansException {
        return null;
    }

    public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
        return null;
    }

    public boolean containsBean(String s) {
        return false;
    }

    public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        return false;
    }

    public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return false;
    }

    public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
        return false;
    }

    public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
        return false;
    }

    public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return null;
    }

    public String[] getAliases(String s) {
        return new String[0];
    }

    public void publishEvent(ApplicationEvent applicationEvent) {

    }

    public void publishEvent(Object o) {

    }

    public String getMessage(String s, Object[] objects, String s1, Locale locale) {
        return null;
    }

    public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
        return null;
    }

    public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
        return null;
    }

    public Environment getEnvironment() {
        return null;
    }

    public Resource[] getResources(String s) throws IOException {
        return new Resource[0];
    }

    public Resource getResource(String s) {
        return null;
    }

    public ClassLoader getClassLoader() {
        return null;
    }
}
