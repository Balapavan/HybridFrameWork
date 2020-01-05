package travelCity.com;

import java.util.ArrayList;
import java.util.List;

public class LegendNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        List<Integer> LegendArray = new ArrayList<>();
        
        //16, 17, 4, 3, 5, 2
        LegendArray.add(3);
        LegendArray.add(4);
        LegendArray.add(-3);
        LegendArray.add(25);
        LegendArray.add(55);
        LegendArray.add(7);

        
        LegendArray.add(16);
        LegendArray.add(17);
        LegendArray.add(4);
        LegendArray.add(3);
        LegendArray.add(5);
        LegendArray.add(2);

        
        
        int maxofRight=0;
        List<Integer> OutputArray = new ArrayList<>();
        System.out.println(LegendArray.size());
        int sise=LegendArray.size();
        for(int i=sise-1;i>0;i--){
  
            int receivedinput=LegendArray.get(i); 
            System.out.println("receivedinput"+receivedinput+ " maxofRight "+maxofRight);
            if(receivedinput>maxofRight)
            {
            	OutputArray.add(receivedinput);  
            	maxofRight=receivedinput;
            	System.out.println(receivedinput);
            }
            
        }   
        System.out.println(LegendArray);
        System.out.println(OutputArray);
        
        

	}

}
