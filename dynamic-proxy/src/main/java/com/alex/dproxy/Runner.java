package com.alex.dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author AlexM
 * Date: 10/27/19
 **/
public class Runner {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        samples();

    }

    private static void samples() throws IllegalAccessException, InstantiationException {
        System.out.println("Java proxy");
        IExample example = JavaProxy.newProxyInstance();
        example.setName("java proxy");

        System.out.println("Java assist proxy");
        example = JavaProxy.javaAssistPorxy();
        example.setName("java assist");

        System.out.println("Cglib proxy");
        example = JavaProxy.javaAssistPorxy();
        example.setName("cglibs");
    }


}
