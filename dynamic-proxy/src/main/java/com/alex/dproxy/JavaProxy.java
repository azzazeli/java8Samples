package com.alex.dproxy;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author AlexM
 * Date: 10/27/19
 **/
public class JavaProxy {
    public static IExample newProxyInstance() {
        Example example = new Example();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                audit();
                return method.invoke(example, args);
            }
        };
        return (IExample) Proxy.newProxyInstance(JavaProxy.class.getClassLoader(),
                new Class[]{IExample.class},
                handler);
    }


    public static IExample javaAssistPorxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(Example.class);
        Class aClass = factory.createClass();
        IExample newInstance = (IExample) aClass.newInstance();
        MethodHandler methodHandler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                audit();
                return proceed.invoke(newInstance, args);
            }
        };
        ((ProxyObject)newInstance).setHandler(methodHandler);
        return newInstance;
    }

    public static IExample cglib() {
        final Example example = new Example();

        return (IExample) Enhancer.create(IExample.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                audit();
                return method.invoke(example, args);
            }
        });
    }


    private static void audit() {
        System.out.println("-------------------------------");
        System.out.println("audit action");
        System.out.println("-------------------------------");
    }
}
