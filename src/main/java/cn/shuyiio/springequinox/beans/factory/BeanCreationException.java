package cn.shuyiio.springequinox.beans.factory;

import cn.shuyiio.springequinox.beans.BeanException;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class BeanCreationException extends BeanException {

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String s, Exception e) {
        super(s, e);
    }
}
