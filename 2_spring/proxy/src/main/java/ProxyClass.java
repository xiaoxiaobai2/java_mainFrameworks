import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyClass {
    public static void main(String[] args) {
        Producer proxyProducer = (Producer) Enhancer.create(Producer.class, new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                if ("saleComputer".equals(method.getName())) {
                    double money = (Double) args[0];
                    returnValue = method.invoke(ProducerImpl.class.newInstance(), money * 0.8);
                }
                return returnValue;
            }
        });

        proxyProducer.saleComputer(10000);
    }
}
