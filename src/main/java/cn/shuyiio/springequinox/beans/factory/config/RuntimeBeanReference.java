package cn.shuyiio.springequinox.beans.factory.config;

/**
 * @author zhoushuyi
 * @since 2018/8/20
 */
public class RuntimeBeanReference {

    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }
    public String getBeanName() {
        return this.beanName;
    }

}
