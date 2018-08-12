package cn.shuyiio.springequinox.v1;

import cn.shuyiio.springequinox.context.ApplicationContext;
import cn.shuyiio.springequinox.context.support.ClassPathXmlApplicationContext;
import cn.shuyiio.springequinox.service.PetPostService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class ApplicationContextTest {


    @Test
    public void acclication() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore.xml");
        PetPostService postService = (PetPostService) ctx.getBean("petStore");

        Assert.assertNotNull(postService);

    }
}
