package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		BaseClass b = new BaseClass();

		Class cls = b.getClass();
		System.out.println(cls.getName());
		Method[] methods = cls.getMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
			if (m.getName().equalsIgnoreCase("sum")) {
				Method methodcall1 = cls.getDeclaredMethod("sum", int.class, int.class);

				// invokes the method at runtime
				int g = (int) methodcall1.invoke(b, 19, 2);

				System.out.println(g);
			}

		}
	}
}
