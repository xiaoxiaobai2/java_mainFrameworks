import java.lang.reflect.Array;
import java.nio.charset.MalformedInputException;
import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        boolean flag=true;
        int num;
        int count=0;
        int[] array=new int[10];


        long start = System.currentTimeMillis();
        int k=0;
        while (count!=9) {
            num = 10;
            while(num>0){
                int t =(int)(Math.random()*10);   //生成0-9之间的数
                array[num-1] = t;
                num--;
            }

            count=0;
            for(int i=0;i<9;i++){
                if(array[i]>array[i+1]){      //只有是从小到大的排列才行
                    count++;
                }
            }
            System.out.println("array = " + Arrays.toString(array));
            System.out.println("以循环"+ k++ +"次\n");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
