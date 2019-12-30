package dataHealper;

import org.testng.annotations.DataProvider;

public class DataProvider_Ant {

	@DataProvider
	public int [][] getData()
	{
		int[][] number=new int[3][3];
		number[0][0]=1;
		number[0][1]=2;
		number[1][0]=3;
		number[1][1]=4;
		System.out.println("Number====>"+number);
		return number;
	}
	
}
