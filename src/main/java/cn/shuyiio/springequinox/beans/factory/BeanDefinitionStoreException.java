package cn.shuyiio.springequinox.beans.factory;

import cn.shuyiio.springequinox.beans.BeanException;


/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class BeanDefinitionStoreException extends BeanException {

    public BeanDefinitionStoreException(String err) {
        super(err);
    }
    public BeanDefinitionStoreException(String err, Throwable e) {
        super(err, e);
    }
}
