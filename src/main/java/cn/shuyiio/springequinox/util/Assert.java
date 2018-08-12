package cn.shuyiio.springequinox.util;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

}
