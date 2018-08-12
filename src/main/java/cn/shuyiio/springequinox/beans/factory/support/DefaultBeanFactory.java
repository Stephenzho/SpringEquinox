package cn.shuyiio.springequinox.beans.factory.support;

import cn.shuyiio.springequinox.beans.BeanDefinition;
import cn.shuyiio.springequinox.beans.config.ConfigurableBeanFactory;
import cn.shuyiio.springequinox.beans.factory.BeanCreationException;
import cn.shuyiio.springequinox.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);


    private ClassLoader classLoader;


    public BeanDefinition getBeanDefinition(String bean) {
        return beanDefinitionMap.get(bean);
    }



    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if (bd == null) {
            return null;
        }

        if (bd.isSingleton()) {
            Object bean =  this.getSingleton(beanID);

            if (bean == null) {
                bean = createBean(bd);

                this.registerSingleton(beanID, bean);
            }
            return bean;
        }
        return createBean(bd);
    }


    private Object createBean(BeanDefinition bd) {
        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
        }
    }


    public void registerBeanDefinition(String id, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(id, beanDefinition);
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.classLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }
}
