package cn.shuyiio.springequinox.beans.factory.support;

import cn.shuyiio.springequinox.beans.config.SingletonBeanRegistry;
import cn.shuyiio.springequinox.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);


    public void registerSingleton(String beanName, Object singletonObject) {

        Assert.notNull(beanName, "'beanName' must not be null");

        Object oldObject = this.singletonObjects.get(beanName);
        if (oldObject != null) {
            throw new IllegalStateException("Could not register object [" + singletonObject +
                    "] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
        }
        this.singletonObjects.put(beanName, singletonObject);
    }

    public Object getSingleton(String beanId) {
        return singletonObjects.get(beanId);
    }

}
