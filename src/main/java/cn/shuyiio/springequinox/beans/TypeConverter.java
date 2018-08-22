package cn.shuyiio.springequinox.beans;

/**
 * @author zhoushuyi
 * @since 2018/8/22
 */
public interface TypeConverter {

    <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;

}
