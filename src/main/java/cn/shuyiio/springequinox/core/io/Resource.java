package cn.shuyiio.springequinox.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

    String getDescription();
}
