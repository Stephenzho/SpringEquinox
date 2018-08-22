package cn.shuyiio.springequinox.v1;

import cn.shuyiio.springequinox.beans.propertyediors.CustomBooleanEditor;
import cn.shuyiio.springequinox.beans.propertyediors.CustomNumberEditor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhoushuyi
 * @since 2018/8/22
 */
public class CustomNumberEditorTest {

    @Test
    public void testConvertString() {
        CustomNumberEditor editor = new CustomNumberEditor(Integer.class,true);

        editor.setAsText("2");
        Object value = editor.getValue();
        Assert.assertTrue(value instanceof Integer);
        Assert.assertEquals(3, ((Integer)editor.getValue()).intValue());


        editor.setAsText("");
        Assert.assertTrue(editor.getValue() == null);


        try{
            editor.setAsText("3.1");

        }catch(IllegalArgumentException e){
            return ;
        }
        Assert.fail();

    }

    @Test
    public void test() {
        CustomBooleanEditor editor = new CustomBooleanEditor(true);

        editor.setAsText("1");

        Object value = editor.getValue();


        System.out.println(value);
    }
}
