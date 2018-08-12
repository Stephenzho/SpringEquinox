package cn.shuyiio.springequinox.beans;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    String SCOPE_DEFAULT = "";

    String getBeanClassName();

    boolean isPrototype();
    boolean isSingleton();

    void setScope(String scope);
    String getScope();
}
