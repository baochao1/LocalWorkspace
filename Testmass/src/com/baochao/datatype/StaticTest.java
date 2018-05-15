package com.baochao.datatype;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class StaticTest {

	public static void main(String[] args) {

		String name;
		if (args.length>0) {
			name = args[0];
		} else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Date):");
			name = in.next();
		}
		
		try {
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0) {
				System.out.println(modifiers + " ");
			}
			System.out.println("class " + name);
			if (supercl != null && supercl !=Object.class) {
				System.out.println("\n{\n");
				printConstructors(cl);
				System.out.println("diyige");
				printMethods(cl);
				System.out.println("dierge");
				System.out.println();
				printFields(cl);
				System.out.println("}");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	public static void printConstructors(Class cl){
		Constructor[] constructors = cl.getDeclaredConstructors();
		
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.println("  ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0){
				System.out.println(modifiers + " ");
				System.out.println(name + "(");
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if(j > 0){
					System.out.println(", ");
				}
				System.out.println(paramTypes[j].getName());
			}
			System.out.println(");");
			}
		}
	}

	public static void printMethods(Class cl){
		Method[] methods = cl.getMethods();
		for (Method method : methods) {
			Class reType = method.getReturnType();
			String name = method.getName();
			System.out.println(" ");
			String modifiers = Modifier.toString(method.getModifiers());
			if (modifiers.length() > 0) {
				System.out.println(modifiers + " ");
			}
			System.out.print(reType.getName() + " " + name + "(");
			Class[] paramTypes = method.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.println(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) {
				System.out.println(modifiers + " " );
				System.out.println(type.getName() + " " + name + ";");
			}
		}
		
	}
	
}









