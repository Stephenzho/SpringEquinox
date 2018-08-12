package cn.shuyiio.springequinox.beans.factory.support;

import cn.shuyiio.springequinox.beans.BeanDefinition;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;


    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

}
