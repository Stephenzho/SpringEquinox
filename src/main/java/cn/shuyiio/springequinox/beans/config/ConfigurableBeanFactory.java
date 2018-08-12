package cn.shuyiio.springequinox.beans.config;

import cn.shuyiio.springequinox.beans.factory.BeanFactory;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public interface ConfigurableBeanFactory extends BeanFactory {


    void setBeanClassLoader(ClassLoader beanClassLoader);


    ClassLoader getBeanClassLoader();
}
