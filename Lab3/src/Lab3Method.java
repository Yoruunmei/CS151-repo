
public class Lab3Method<E> {

	
	public void dumpArray(E[] a) {
		String result = toString(a);
		
		System.out.println(result);
	}
	
	public String toString(E[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i].toString() + ", ";
		}
		//System.out.println("chicken");
		return s;
	}
}
