import java.awt.Rectangle;
import java.lang.reflect.*;
import java.util.ArrayList;

public class Chapter7 {
	// Check under Reflection section of book.
	
	static class Test {
		protected ArrayList<Integer> f;
		public Test() {
			
		}
		public Test(int i, String j, boolean k) {
			
		}
	}
	
	// Should print out name of class, superclass
	// constructors, methods, fields (including param & field types and modifies)
	public static <E> void dumpClass(E obj) {
		System.out.println("-> Running...");
		
		Class clss = obj.getClass();
		//Package pckg = obj.getClass().getPackage();
		// Don't need to use toString().
		// .getClass().getSimpleName() prints only name of class
		
		System.out.println("Class : "+clss); // Class name
		System.out.println("Package : "+clss.getPackage());	// Package name
		System.out.println("Superclass : "+clss.getSuperclass()); // Superclass
		
		Constructor[] constructors = clss.getDeclaredConstructors(); // Constructors
		System.out.print("Constructors : ");
		boolean firstPrinted1 = false;
		for (Constructor c : constructors) {
			if (!firstPrinted1) {
				System.out.println(c); 
				firstPrinted1 = true;
			} else {
				System.out.println("               " +c);
			}
		}
		
		Method[] methods = clss.getDeclaredMethods(); // Methods
		System.out.print("Methods : ");
		boolean firstPrinted2 = false;
		for (Method c : methods) {
			if (!firstPrinted2) {
				System.out.println(c); 
				firstPrinted2 = true;
			} else {
				System.out.println("          " +c);
			}
		}
		
		if (methods.length == 0)
			System.out.println();
		
		Field[] fields = clss.getDeclaredFields(); // Fields
		System.out.print("Fields : ");
		boolean firstPrinted3 = false;
		for (Field c : fields) {
			if (!firstPrinted3) {
				System.out.println(c); 
				firstPrinted3 = true;
			} else {
				System.out.println("         " +c);
			}
		}
		
		if (fields.length == 0)
			System.out.println();
		System.out.println("-> Done...\n");
	}
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		dumpClass(obj1);
		
		Rectangle r = new Rectangle();
		dumpClass(r);
		
		Test a = new Test();
		dumpClass(a);
	}
}
