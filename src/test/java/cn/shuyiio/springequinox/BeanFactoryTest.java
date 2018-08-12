package cn.shuyiio.springequinox;

import cn.shuyiio.springequinox.beans.BeanDefinition;
import cn.shuyiio.springequinox.beans.factory.BeanFactory;
import cn.shuyiio.springequinox.beans.factory.support.DefaultBeanFactory;
import cn.shuyiio.springequinox.beans.factory.xml.XmlBeanDefinitionReader;
import cn.shuyiio.springequinox.service.PetPostService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class BeanFactoryTest {

    DefaultBeanFactory beanFactory;
    XmlBeanDefinitionReader reader;

    @Before
    public void setup() {
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
    }




    @Test
    public void testgetbean() {

        reader.loadBeanDefinitions("petstore.xml");

        BeanDefinition petStore = beanFactory.getBeanDefinition("petStore");

        assertEquals("cn.shuyiio.springequinox.service.PetPostService", petStore.getBeanClassName());


        PetPostService postService = (PetPostService) beanFactory.getBean("petStore");

        assertNotNull(postService);


    }
}
