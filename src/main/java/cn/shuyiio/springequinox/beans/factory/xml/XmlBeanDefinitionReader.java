package cn.shuyiio.springequinox.beans.factory.xml;

import cn.shuyiio.springequinox.beans.BeanDefinition;
import cn.shuyiio.springequinox.beans.factory.BeanDefinitionStoreException;
import cn.shuyiio.springequinox.beans.factory.support.BeanDefinitionRegistry;
import cn.shuyiio.springequinox.beans.factory.support.GenericBeanDefinition;
import cn.shuyiio.springequinox.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @author zhoushuyi
 * @since 2018/8/12
 */
public class XmlBeanDefinitionReader {

    private final static String ID_ATTRIBUTE = "id";
    private final static String CLASS_ATTRIBUTE = "class";

    public static final String SCOPE_ATTRIBUTE = "scope";

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.beanDefinitionRegistry = registry;
    }



    public void loadBeanDefinitions(Resource resource){
        InputStream is = null;
        try{
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement(); //<beans>
            Iterator iter = root.elementIterator();

            while(iter.hasNext()){
                Element ele = (Element) iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);

                BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);


                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }


                this.beanDefinitionRegistry.registerBeanDefinition(id, bd);
            }

        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(), e);
        } finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }



}
