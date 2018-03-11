package JavaCode;

import java.util.HashMap;

public class Practice {

	public static void main(String[] args) {
		int list[] = {3,4,6,8};
		int m;
		for(m=0;m<=3;m++)
		{
			if(!(list[m]%2==0))
			{
				System.out.println("Prime numbers are " + list[m]);
			}
			
		}
		
		int n = 5, i, fact = 1;
		for (i = 1; i <= n; i++)

		{
			fact = fact * i;

		}
		System.out.println(fact);
		
		String original="madam",palindrome="";
		for(int i1=original.length()-1;i1>=0;i1--)
		{
			palindrome=palindrome+original.charAt(i1);
		}
		
		if(original.equals(palindrome))
			
		{
			
			System.out.println(original + " is palindrome");
		}
		
		HashMap<Character,Integer> hsMap=new HashMap<Character,Integer>();
		String str= "Java J2EE Java Java"; 
		char[] strArray=str.toCharArray();
		for(char c : strArray)
		{
			if(hsMap.containsKey(c))
			{
			hsMap.put(c, hsMap.get(c)+1);
			}
			else
			{
				hsMap.put(c, 1);
			}
								}
		System.out.println(hsMap);
					
	}
	
	
}
