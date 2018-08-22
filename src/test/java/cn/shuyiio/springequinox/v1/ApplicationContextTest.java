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
import cn.shuyiio.springequinox.dao.AccountDao;
import cn.shuyiio.springequinox.dao.ItemDao;
import cn.shuyiio.springequinox.service.PetPostService;
import cn.shuyiio.springequinox.service.v2.PetPostService2;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class ApplicationContextTest {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore.xml");
        PetPostService2 petStore = (PetPostService2)ctx.getBean("petStore");

        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());

        assertTrue(petStore.getAccountDao() instanceof AccountDao);
        assertTrue(petStore.getItemDao() instanceof ItemDao);

        assertEquals("zhoushuyi",petStore.getName());
        assertEquals(1, petStore.getVersion());

    }


    @Test
    public void testGetBeanDefinition() {

        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(new ClassPathResource("petstore.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        List<PropertyValue> pvs = bd.getPropertyValues();

        assertTrue(pvs.size() == 4);
        {
            PropertyValue pv = this.getPropertyValue("accountDao", pvs);

            assertNotNull(pv);

            assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

        {
            PropertyValue pv = this.getPropertyValue("itemDao", pvs);

            assertNotNull(pv);

            assertTrue(pv.getValue() instanceof RuntimeBeanReference);
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

        assertNotNull(postService);
    }


    @Test
    public void fileTest() {

        ApplicationContext context = new FileSystemXmlApplicationContent("D:\\Developers\\IdeaProjects\\springequinox\\src\\test\\resources\\petstore.xml");

        PetPostService postService = (PetPostService) context.getBean("petStore");

        assertNotNull(postService);

    }


}
