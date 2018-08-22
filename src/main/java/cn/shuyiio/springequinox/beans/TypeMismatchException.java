package cn.shuyiio.springequinox.beans;

/**
 * @author zhoushuyi
 * @since 2018/8/22
 */
public class TypeMismatchException extends BeanException {

    private transient Object value;

    private Class<?> requiredType;

    public TypeMismatchException( Object value, Class<?> requiredType) {
        super("Failed to convert value :"+value + "to type "+requiredType);
        this.value = value;
        this.requiredType = requiredType;
    }

    public Object getValue() {
        return value;
    }

    public Class<?> getRequiredType() {
        return requiredType;
    }
}
