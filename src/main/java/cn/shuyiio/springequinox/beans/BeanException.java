package cn.shuyiio.springequinox.beans;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class BeanException extends RuntimeException{


    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
