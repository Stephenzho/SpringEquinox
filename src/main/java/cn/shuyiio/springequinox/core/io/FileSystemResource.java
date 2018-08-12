package cn.shuyiio.springequinox.core.io;

import cn.shuyiio.springequinox.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class FileSystemResource implements Resource {
    private String path;
    private File file;

    public FileSystemResource(String path) {
        Assert.notNull(path, "路径为null");
        this.path = path;
        this.file = new File(path);
    }



    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getDescription() {
        return "file: ["+file.getAbsoluteFile() + "]";
    }
}
