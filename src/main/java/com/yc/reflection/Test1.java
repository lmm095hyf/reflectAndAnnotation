package com.yc.reflection;

import java.lang.reflect.*;
import java.util.*;


//在程序运行过程中，有人给了一个类，请动态的了解这个类，且创建这个类的对象
public class Test1 {
    public static <Showable> void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入类路径");
            String path=sc.nextLine();
            System.out.println("带加载的类："+path);

            Class c=Class.forName(path);
            String name=c.getName();
            System.out.println(name);

            //Field[] fs=c.getFields();
            Field[] fs=c.getDeclaredFields();//Declared 自己声明的
            if(fs!=null && fs.length>0){
                for(Field f:fs){
                    //private
                    String modifier="";
                    switch (f.getModifiers()){
                        case 1:
                            modifier="public";
                            break;
                        case 2:
                            modifier="private";
                            break;
                    }
                    System.out.println(modifier+"\t"+f.getName());
                }
            }

            Method[] ms= c.getDeclaredMethods();
            if(ms!=null && ms.length>0){
                for(Method m:ms){
                    System.out.println(m.getModifiers()+"\t"+m.getReturnType().toString()+"\t"+m.getName());
                }
            }

            Constructor[] cs=c.getConstructors();
            if(cs !=null && cs.length>0){
                for(Constructor m:cs){
                    System.out.println(m.getModifiers()+"\t"+m.getName());
                }
            }
            
            //利用反射完成实例化操作
            Object o=c.newInstance();//无参构造
            if(o instanceof Showable){
                Showable p=(Showable)o;
                p.show();
            }

            //利用反射调用某个方法  适合JavaEE中的规范化方法调用场景
            System.out.println("============");
            if(ms!=null && ms.length>0){
                for(Method m:ms){
                    if(m.getName().startsWith("sh")){
                        m.invoke(o);
                    }
                }
            }

            Map<String, String> pMap = new HashMap<String, String>();
            pMap.put("name","张三");
            pMap.put("age",30+"");
            Object oo=setValues(pMap,c);
            System.out.println(oo.toString());
            
        }
    }

    public static Object setValues(Map<String,String> map,Class cls) throws IllegalAccessException, InstantiationException {
        Object o=null;
        o=cls.newInstance();
        Method[] ms=cls.getDeclaredMethods();
        if(ms!=null && ms.length>0){
            for(Method m:ms){
                if(m.getName().startsWith("set")){
                    String mName=m.getName();
                    String fName=mName.substring(3).toLowerCase();
                    String value=map.get(fName);
                    if("Integer".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName())||"Int".equalsIgnoreCase(m.getParameterTypes()[0])){
                        m.invoke('0',Integer.parseInt(value));
                    }else{
                        m.invoke(o,value);
                    }
                }
            }
        }
        return 0;
    }





}
