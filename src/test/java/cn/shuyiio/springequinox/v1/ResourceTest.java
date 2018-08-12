package cn.shuyiio.springequinox.v1;

import cn.shuyiio.springequinox.core.io.ClassPathResource;
import cn.shuyiio.springequinox.core.io.FileSystemResource;
import cn.shuyiio.springequinox.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class ResourceTest {


    @Test
    public void retest() throws IOException {
        Resource resource = new ClassPathResource("petstore.xml");

        InputStream is = null;
        try{

            is = resource.getInputStream();

            Assert.assertNotNull(is);

        }finally {
            if (is != null) {
                is.close();
            }

        }
    }

    @Test
    public void fileSystemtest() throws IOException {
        Resource resource = new FileSystemResource("D:\\Developers\\IdeaProjects\\springequinox\\src\\test\\resources\\petstore.xml");

        InputStream is = null;
        try{

            is = resource.getInputStream();

            Assert.assertNotNull(is);

        }finally {
            if (is != null) {
                is.close();
            }

        }
    }
}
