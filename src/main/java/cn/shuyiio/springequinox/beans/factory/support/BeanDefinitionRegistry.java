package cn.shuyiio.springequinox.beans.factory.support;

import cn.shuyiio.springequinox.beans.BeanDefinition;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanID);


    void registerBeanDefinition(String beanID, BeanDefinition bd);

}
