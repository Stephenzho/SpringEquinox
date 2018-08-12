package cn.shuyiio.springequinox.context.support;

import cn.shuyiio.springequinox.beans.factory.support.DefaultBeanFactory;
import cn.shuyiio.springequinox.beans.factory.xml.XmlBeanDefinitionReader;
import cn.shuyiio.springequinox.context.ApplicationContext;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {


    private DefaultBeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String configFile) {
        this.beanFactory = new DefaultBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(configFile);
    }



    /**
     * 获取bean实例
     * @param beanID bean实例的id
     * @return
     */
    public Object getBean(String beanID) {
        return beanFactory.getBean(beanID);
    }

}
