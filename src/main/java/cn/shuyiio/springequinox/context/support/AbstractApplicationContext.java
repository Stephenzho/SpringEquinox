package cn.shuyiio.springequinox.context.support;

import cn.shuyiio.springequinox.beans.factory.support.DefaultBeanFactory;
import cn.shuyiio.springequinox.beans.factory.xml.XmlBeanDefinitionReader;
import cn.shuyiio.springequinox.context.ApplicationContext;
import cn.shuyiio.springequinox.core.io.Resource;
import cn.shuyiio.springequinox.util.ClassUtils;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public abstract class AbstractApplicationContext  implements ApplicationContext {

    private DefaultBeanFactory beanFactory;
    private ClassLoader classLoader;


    public AbstractApplicationContext(String path) {
        this.beanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        Resource resource = this.getResource(path);
        reader.loadBeanDefinitions(resource);

        beanFactory.setBeanClassLoader(this.getBeanClassLoader());
    }


    /**
     * 获取bean实例
     * @param beanID bean实例的id
     * @return
     */
    public Object getBean(String beanID) {
        return beanFactory.getBean(beanID);
    }


    public abstract Resource getResource(String path);


    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.classLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }
}
