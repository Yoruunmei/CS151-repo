
public class Chapter7 {
	// Check under Reflection section of book.
	
	static class Test {
		public Test(int i) {
			
		}
	}
	
	// Should print out name of class, superclass
	// constructors, methods, fields (including param & field types and modifies)
	public static <E> void dumpClass(E obj) {
		System.out.println("Running...");
		Class clss = obj.getClass();
		Package pckg = obj.getClass().getPackage();
		// Don't need to use toString()
		System.out.println(pckg); // Package name
		//System.out.println(pckg.getName());	
		
		System.out.println(clss);
		//System.out.println(clss.getName());
		
		
		System.out.println("Done...");
	}
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		dumpClass(obj1);
		
		System.out.println("t here");
		Chapter7 t = new Chapter7();
		dumpClass(t);
		
	}
}
