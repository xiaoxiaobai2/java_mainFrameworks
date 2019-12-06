import org.junit.Test;

/**
 * 测试查找问号
 */
public class Test02 {
    @Test
    public void test02(){
        String s= "abc?defc?cc";
        int i = s.indexOf('?');
        System.out.println("i = " + i);
    }
}
