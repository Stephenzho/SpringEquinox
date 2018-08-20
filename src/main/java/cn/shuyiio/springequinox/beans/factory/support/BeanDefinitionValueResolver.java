package cn.shuyiio.springequinox.beans.factory.support;

import cn.shuyiio.springequinox.beans.factory.config.RuntimeBeanReference;
import cn.shuyiio.springequinox.beans.factory.config.TypedStringValue;

/**
 * @author zhoushuyi
 * @since 2018/8/20
 */
public class BeanDefinitionValueResolver {

    private final DefaultBeanFactory beanFactory;

    public BeanDefinitionValueResolver(DefaultBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(Object value) {

        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            String refName = ref.getBeanName();
            Object bean = this.beanFactory.getBean(refName);
            return bean;

        }else if (value instanceof TypedStringValue) {
            return ((TypedStringValue) value).getValue();
        } else{

            throw new RuntimeException("the value " + value +" has not implemented");
        }
    }


}
