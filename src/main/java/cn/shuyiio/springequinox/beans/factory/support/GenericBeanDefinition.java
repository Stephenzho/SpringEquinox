package cn.shuyiio.springequinox.beans.factory.support;

import cn.shuyiio.springequinox.beans.BeanDefinition;
import cn.shuyiio.springequinox.beans.ConstructorArgument;
import cn.shuyiio.springequinox.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;
    private boolean singleton = true;
    private boolean prototype = false;
    private String scope = SCOPE_DEFAULT;

    private ConstructorArgument constructorArgument = new ConstructorArgument();

    List<PropertyValue> propertyValues = new ArrayList<>();

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {

        return this.beanClassName;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }

    @Override
    public boolean isPrototype() {
        return this.prototype;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }

    @Override
    public ConstructorArgument getConstructorArgument() {
        return constructorArgument;
    }


    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

}
