package 排序;

import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class ProxyTest implements InvocationHandler {
    private Object target;

    public ProxyTest(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start=System.currentTimeMillis();
        Object o = method.invoke(target, args);
        long end= System.currentTimeMillis();
        System.out.println((double) (end-start)/1000);

        return o;
    }
}
