package cn.shuyiio.springequinox.beans.factory;

import cn.shuyiio.springequinox.beans.BeanDefinition;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public interface BeanFactory {


    BeanDefinition getBeanDefinition(String bean);

    Object getBean(String beanID);


}
