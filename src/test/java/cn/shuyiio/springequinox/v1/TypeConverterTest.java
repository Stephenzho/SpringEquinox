package cn.shuyiio.springequinox.v1;

import cn.shuyiio.springequinox.beans.SimpleTypeConverter;
import cn.shuyiio.springequinox.beans.TypeConverter;
import cn.shuyiio.springequinox.beans.TypeMismatchException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhoushuyi
 * @since 2018/8/22
 */
public class TypeConverterTest {

    @Test
    public void testConvertStringToInt() {
        TypeConverter converter = new SimpleTypeConverter();
        Integer i = converter.convertIfNecessary("3", Integer.class);
        Assert.assertEquals(3,i.intValue());

        try{
            converter.convertIfNecessary("3.1", Integer.class);
        }catch(TypeMismatchException e){
            return;
        }
    }
    @Test
    public void testConvertStringToBoolean(){
        TypeConverter converter = new SimpleTypeConverter();
        Boolean b = converter.convertIfNecessary("true", Boolean.class);
        Assert.assertEquals(true,b.booleanValue());

        try{
            converter.convertIfNecessary("xxxyyyzzz", Boolean.class);
        }catch(TypeMismatchException e){
            return;
        }
    }


}
