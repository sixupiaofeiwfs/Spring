package com.wfs.util;

import com.wfs.com.wfs.dao.DeptDao;
import com.wfs.com.wfs.dao.DeptDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Start {

    /**
     * 演示JDK动态代理增强方法
     * 第一步：创建一个接口
     * 第二步：创建一个类实现该接口
     * 第三步：创建动态代理对象
     */
    public static void main(String[] args) {


        Class[] interfaces= {DeptDao.class};

        DeptDaoImpl deptDao=new DeptDaoImpl();

        DeptDao dao = (DeptDao) Proxy.newProxyInstance(Start.class.getClassLoader(), interfaces, new DeptDaohandel(deptDao));

//        int add = dao.add(4, 5);
//        System.out.println("执行结果为："+add);


        String result=dao.query("2");
        System.out.println(result);
    }


}
//创建代理对象
class DeptDaohandel  implements InvocationHandler{

    private Object obj;

    public DeptDaohandel(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("执行方法之前");

        Object res = method.invoke(obj, args);



        System.out.println("执行方法之后");

        return res;
    }
}
