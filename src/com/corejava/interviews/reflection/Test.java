package com.corejava.interviews.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, 
						NoSuchMethodException, SecurityException, IllegalAccessException, 
						IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
		MyClass myClass = new MyClass(13,"firstname","lastname");
		System.out.println("before: "+myClass);
		Class my_class = Class.forName("com.corejava.interviews.reflection.MyClass");
		Method[] methods = my_class.getMethods();
		List<Method> methodList = Arrays.asList(methods);
//		methodList.forEach(x->System.out.println(x.getName())); // no private methods
		
//		Method method = my_class.getDeclaredMethod("setLastName", String.class); // can get private method
		Method method = MyClass.class.getDeclaredMethod("setLastName", String.class);
		method.setAccessible(true);
		System.out.println(method.getName());
		method.invoke(myClass, "lastname2");
		//example for how to use newInstance to create a new instance
//		Constructor constructor = MyClass.class.getDeclaredConstructor(int.class,String.class,String.class);
//		MyClass myClass = (MyClass) constructor.newInstance(12,"firstname","lastname");
		
		
		System.out.println("after: "+myClass);

		
		
	}

}
