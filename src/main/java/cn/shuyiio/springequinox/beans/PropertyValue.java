package cn.shuyiio.springequinox.beans;

/**
 * @author zhoushuyi
 * @since 2018/8/20
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    private boolean converted = false;

    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }
    public synchronized boolean isConverted() {
        return this.converted;
    }


    public synchronized void setConvertedValue(Object value) {
        this.converted = true;
        this.convertedValue = value;
    }

    public synchronized Object getConvertedValue() {
        return this.convertedValue;
    }
}
