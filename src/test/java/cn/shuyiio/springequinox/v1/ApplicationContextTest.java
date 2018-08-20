package cn.shuyiio.springequinox.v1;

import cn.shuyiio.springequinox.beans.BeanDefinition;
import cn.shuyiio.springequinox.beans.PropertyValue;
import cn.shuyiio.springequinox.beans.factory.config.RuntimeBeanReference;
import cn.shuyiio.springequinox.beans.factory.support.DefaultBeanFactory;
import cn.shuyiio.springequinox.beans.factory.xml.XmlBeanDefinitionReader;
import cn.shuyiio.springequinox.context.ApplicationContext;
import cn.shuyiio.springequinox.context.support.ClassPathXmlApplicationContext;
import cn.shuyiio.springequinox.context.support.FileSystemXmlApplicationContent;
import cn.shuyiio.springequinox.core.io.ClassPathResource;
import cn.shuyiio.springequinox.service.PetPostService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class ApplicationContextTest {


    @Test
    public void testGetBeanDefinition() {

        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(new ClassPathResource("petstore.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        List<PropertyValue> pvs = bd.getPropertyValues();

        Assert.assertTrue(pvs.size() == 2);
        {
            PropertyValue pv = this.getPropertyValue("accountDao", pvs);

            Assert.assertNotNull(pv);

            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

        {
            PropertyValue pv = this.getPropertyValue("itemDao", pvs);

            Assert.assertNotNull(pv);

            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

    }


    private PropertyValue getPropertyValue(String name,List<PropertyValue> pvs){
        for(PropertyValue pv : pvs){
            if(pv.getName().equals(name)){
                return pv;
            }
        }
        return null;
    }


    @Test
    public void acclication() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore.xml");
        PetPostService postService = (PetPostService) ctx.getBean("petStore");

        Assert.assertNotNull(postService);
    }


    @Test
    public void fileTest() {

        ApplicationContext context = new FileSystemXmlApplicationContent("D:\\Developers\\IdeaProjects\\springequinox\\src\\test\\resources\\petstore.xml");

        PetPostService postService = (PetPostService) context.getBean("petStore");

        Assert.assertNotNull(postService);

    }


}
