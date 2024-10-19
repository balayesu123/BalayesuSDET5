package com.POM_Class;

public class Interview {

	public static void main(String[] args) {
		
		String str = "ABC@123@abcA%$";
		
		String upc="";  String lc = ""; String nm="";  String sym="";
		
		int upcCount=0;  int lcCount = 0; int nmCount=0;  int symCount=0;
		
		 
		for (int i=0; i < str.length() ; i++) {
			
		      char ch = str.charAt(i);
			
			if(Character.isAlphabetic(ch) && Character.isUpperCase(ch))
			{
				upc = upc+str.charAt(i);
				upcCount++;
				
			}
			else if(Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
				
				lc = lc+str.charAt(i);
				lcCount++;	
			}
			else if(Character.isDigit(ch)) {
				
				nm = nm+str.charAt(i);
				nmCount++;		
					
			}
			else
			{
				
				sym = sym+str.charAt(i);
				symCount++;
			}
			
		}
		
		System.out.println(upc + " = " + upcCount);
		System.out.println(lc + " = " + lcCount);
		System.out.println(nm + " = " + nmCount);
		System.out.println(sym + " = " + symCount);
	}

}
