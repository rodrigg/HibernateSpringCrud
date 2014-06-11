/**
 * 
 */
package com.rodionbykov.strings;

/**
 * @author rodionbykov
 *
 */
public class StringsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "1233333333456789";
		String b = a.replace("3", "33");
		System.out.println(b);
		
		System.out.println(a.compareTo(b));
		
		System.out.println(a.contains("12")); //true
		System.out.println(a.contains(b)); //false
	}

}
