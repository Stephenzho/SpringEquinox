package cn.shuyiio.springequinox.v3;

import cn.shuyiio.springequinox.context.ApplicationContext;
import cn.shuyiio.springequinox.context.support.ClassPathXmlApplicationContext;
import cn.shuyiio.springequinox.service.PetPostService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author zhoushuyi
 * @since 2018/9/18
 */
public class ApplicationContextTestV3 {

    @Test
    public void cust() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore.xml");
        PetPostService postService = (PetPostService) ctx.getBean("petStore");

        assertNotNull(postService);


    }
}
