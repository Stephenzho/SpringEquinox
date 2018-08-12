package cn.shuyiio.springequinox.beans.config;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);


}
