import com.zhanghao.mybatis.io.Resources;
import com.zhanghao.mybatis.utils.XmlHelper;
import org.junit.Test;

import java.io.InputStream;

public class TestXMLHelper {
    @Test
    public void testXMLHelper(){
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        XmlHelper.getConf(is);
    }
}
