package cn.shuyiio.springequinox.context.support;

import cn.shuyiio.springequinox.core.io.FileSystemResource;
import cn.shuyiio.springequinox.core.io.Resource;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class FileSystemXmlApplicationContent extends AbstractApplicationContext {

    public FileSystemXmlApplicationContent(String path) {
        super(path);
    }

    @Override
    public Resource getResource(String path) {
        return new FileSystemResource(path);
    }


}
