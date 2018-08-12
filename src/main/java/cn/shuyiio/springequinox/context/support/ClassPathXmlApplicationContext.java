package cn.shuyiio.springequinox.context.support;

import cn.shuyiio.springequinox.core.io.ClassPathResource;
import cn.shuyiio.springequinox.core.io.Resource;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {



    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }



    @Override
    public Resource getResource(String path) {
        return new ClassPathResource(path);
    }


}
