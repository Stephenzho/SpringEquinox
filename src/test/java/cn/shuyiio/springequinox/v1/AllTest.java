package cn.shuyiio.springequinox.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class
})
public class AllTest {


}
