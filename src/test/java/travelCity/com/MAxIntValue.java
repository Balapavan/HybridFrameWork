package travelCity.com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MAxIntValue {

	public static void main(String[] args) {
		  
		/*
			int n, max;
	        Scanner s = new Scanner(System.in);
	        System.out.print("Enter number of elements in the array:");
	        n = s.nextInt();
	        int a[] = new int[n];
	        System.out.println("Enter elements of array:");
	        for(int i = 0; i < n; i++)
	        {
	            a[i] = s.nextInt();
	        }
	        max = a[0];
	        for(int i = 0; i < n; i++)
	        {
	            if(max < a[i])
	            {
	                max = a[i];
	            }
	        }
	        System.out.println("Maximum value:"+max);
*/
	        String input="abcd sdfdsfnds, f132454 !@ sfj$%^&*()-=/.,<> dfsd;f ';'[] ffd";
	        String alphaOnly = input.replaceAll("[^a-zA-Z]+","");
	        String alphaAndDigits = input.replaceAll("[^a-zA-Z0-9]+","");
	        System.out.println("alphaOnly :"+alphaOnly);
	        System.out.println("alphaAndDigits :"+alphaAndDigits);
	        System.out.println("Only Numbers :"+input.replaceAll("[a-zA-Z]", "").replaceAll("[^a-zA-Z0-9\\\\s+]", ""));
	       
	        CharSequence ch="111";
	        ch=ch+" okkkkk";
	        System.out.println("ch-->"+ch);
	        String s="a";
	        System.out.println(s.compareTo(alphaAndDigits));
	        
	}

}
